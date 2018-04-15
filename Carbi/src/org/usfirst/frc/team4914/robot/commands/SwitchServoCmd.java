package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchServoCmd extends Command {

	//TODO: this command might be unused
	
    public SwitchServoCmd() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.m_intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_intake.servoOut();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
