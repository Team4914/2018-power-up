package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoConditionalDropoff extends Command {
	String autoType;
	Command dropoffDrive;
	
	boolean initialized = false;

    public AutoConditionalDropoff(String autoType) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.autoType = autoType;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	// dump at 
    	if (this.autoType == "baselineLeft" && RobotConstants.ortnSwitch == 'L') {
    		// set waypoints
    	}
    	else if (this.autoType == "baselineRight" && RobotConstants.ortnOppSwitch == 'R') {
    		// set waypoints
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!initialized) {
    		initialize();
    		initialized = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
