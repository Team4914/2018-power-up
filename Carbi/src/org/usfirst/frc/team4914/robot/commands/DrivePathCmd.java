package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.FalconPathPlanner;
import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @deprecated
 * Drives the robot given a set of waypoints and a timeframe
 * Generates velocity profile using FalconPathPlanner
 */
public class DrivePathCmd extends Command {
	
	int i = 0;
	FalconPathPlanner path;
	
	double[][] waypoints;
	double totalTime;
	
	double leftSpeed = 0;
	double rightSpeed = 0;
	boolean isFinished = false;

    public DrivePathCmd(double[][] waypoints, double totalTime) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.waypoints = waypoints;
    	this.totalTime = totalTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	i = 0;
    	isFinished = false;
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
