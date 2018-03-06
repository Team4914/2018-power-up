package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SquareCube extends Command {

	char orientation = 'l';
	
    public SquareCube(char orientation) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.orientation = orientation;
    	requires(Robot.m_intake);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (orientation == 'l') {
    		// rotate cube counterclockwise
    		Robot.m_intake.set(-0.8, 0.8);
    	} else {
    		Robot.m_intake.set(0.8, -0.8);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
