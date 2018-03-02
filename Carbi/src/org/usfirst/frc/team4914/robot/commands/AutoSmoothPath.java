package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.FalconPathPlanner;
import org.usfirst.frc.team4914.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoSmoothPath extends Command {
	
	int i = 0;
	FalconPathPlanner path;

    public AutoSmoothPath() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	i = 0;
    	path = FalconPathPlanner.main(null);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Timer.delay(0.1);
    	Robot.m_drivetrain.tankDrive(-path.smoothRightVelocity[i][1]/60.0, -path.smoothLeftVelocity[i][1]/60.0);
    	System.out.println("X:" + path.smoothLeftVelocity[i][1] + "Y:" + path.smoothRightVelocity[i][1]);
    	i++;
    	System.out.println("Index:" + i);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return i >= 46;
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
