package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftRezero extends Command {

    public LiftRezero() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(2);
    	Robot.m_lift.setSoftLimit(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_lift.setSpeed(-0.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_lift.stopMotor();
    	Robot.m_lift.resetQuad();
    	Robot.m_lift.setSoftLimit(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
