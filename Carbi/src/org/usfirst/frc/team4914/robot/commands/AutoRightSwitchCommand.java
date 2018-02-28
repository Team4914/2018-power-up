package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRightSwitchCommand extends Command {

    public AutoRightSwitchCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double ratio = 0.65;
    	double base = -0.5;
    	
    	setTimeout(1.75);
    	while(!isTimedOut()) {
    		Robot.m_drivetrain.tankDrive(base, base*ratio);
    	}
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
    	Robot.m_drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
