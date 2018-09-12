package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.FalconPathPlanner;
import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Identical to AutoDrivePath, except it picks a path based on the game specific
 *  message provided at the beginning of each match.
 *  
 * If not at competition and testing code, set the GSM can be set in the DS
 */
public class AutoDrivePathCmd extends Command {
	
	/*
	 * Type of autonomous mode
	 * "switch" - start in center of alliance and own switch
	 * "baselineLeft" - cross baseline from left side, and dump if owned
	 * "baselineRight" - cross baseline from right side, and dump if owned
	 */
	String autoType = "";
	
	// index of velocity profile to access velocities
	int i = 0;
	// total time of entire drive path
	double totalTime;
	
	// waypoints to generate path from
	double[][] waypoints;
	// FalconPathPlanner path to drive
	FalconPathPlanner path;
	
	// if the left/right waypoints have been properly iniitalized based on GSM
	boolean initialized = false;
	
	double leftSpeed = 0;
	double rightSpeed = 0;
	
	boolean isFinished = false;

    public AutoDrivePathCmd(String autoType) {
    	this.autoType = autoType;
    }

    // Called just before this Command runs the first time
    // Needs to be called when execute is run for the first time
    protected void initialize() {
    	i = 0;
    	isFinished = false;
    	
    	if (this.autoType.equals("switch")) {
        	
        	System.out.println("Auto switch cmd called");
    		
    		// left switch waypoints
    		if (RobotConstants.ortnSwitch == 'L') {
    			waypoints = RobotConstants.k_SwitchAutoLeftFPPWaypoints;
        	}
    		// right switch waypoints
    		else if (RobotConstants.ortnSwitch == 'R') {
    			waypoints = RobotConstants.k_SwitchAutoRightFPPWaypoints;
        	} else {
        		System.out.println("Didn't initialize");
        	}
    		
    		// set timeout to switch timeout
    		totalTime = RobotConstants.k_SwitchAutoFPPTime;
    		
    	} else if (this.autoType.equals("baselineLeft")) {
    		waypoints = RobotConstants.k_BaselineAutoStraightWaypoints;
    		totalTime = 4;
    	} else if (this.autoType.equals("baselineRight")) {
    		waypoints = RobotConstants.k_BaselineAutoStraightWaypoints;
    		totalTime = 4;
    	}
    	
    	// generate path
    	path = FalconPathPlanner.generatePath(waypoints, totalTime);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// reinitialize for GSM
    	if (!initialized) {
    		initialize();
    		initialized = true;
    	}
    	
    	// delay for the time step specified
    	Timer.delay(RobotConstants.k_FPPTimeStep);
    	
    	try {
    		double desiredVoltage = 12.0;
    		double actualVoltage = DriverStation.getInstance().getVoltage();
    		double ratio = desiredVoltage/actualVoltage;
    		// access left and right speeds
    		leftSpeed = (ratio)-path.smoothRightVelocity[i][1]/60.0;
    		rightSpeed = (ratio)-path.smoothLeftVelocity[i][1]/60.0;
    		// 
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
