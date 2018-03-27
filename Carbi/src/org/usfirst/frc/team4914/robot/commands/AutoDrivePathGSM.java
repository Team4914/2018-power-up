package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.FalconPathPlanner;
import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Identical to AutoDrivePath, except it picks a path based on GSM
 */
public class AutoDrivePathGSM extends Command {
	
	String autoType = "";
	
	int i = 0;
	FalconPathPlanner path;
	
	double[][] waypoints;
	double totalTime;
	
	double leftSpeed = 0;
	double rightSpeed = 0;
	boolean isFinished = false;

    public AutoDrivePathGSM(String autoType) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.autoType = autoType;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	i = 0;
    	isFinished = false;
    	
    	if (this.autoType.equals("switch")) {
    		if (RobotConstants.ortnSwitch == 'L') { // drive to left switch
    			waypoints = RobotConstants.k_SwitchAutoLeftFPPWaypoints;
        	} else { // drive to right switch
    			waypoints = RobotConstants.k_SwitchAutoRightFPPWaypoints;
        	}
    		// set timeout to switch timeout
    		totalTime = RobotConstants.k_SwitchAutoFPPTime;
    	}
    	
    	// generate path
    	path = FalconPathPlanner.generatePath(waypoints, totalTime);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Timer.delay(RobotConstants.k_FPPTimeStep);
    	
    	try {
    		leftSpeed = -path.smoothRightVelocity[i][1]/60.0;
    		rightSpeed = -path.smoothLeftVelocity[i][1]/60.0;
    	
    		Robot.m_drivetrain.tankDrive(leftSpeed, rightSpeed);
    	} catch (IndexOutOfBoundsException e) {
    		isFinished = true;
    	}
    		
    	i++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
