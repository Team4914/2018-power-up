// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team4914.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.usfirst.frc.team4914.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4914.robot.Robot;

/**
 *
 */
public class DriveStraightCommand extends Command {

	public double baseSpeed;
	public double leftSpeed;
	public double rightSpeed;
	public double angleOffset;
	public static final double KP = 0.005; //Needs to be fine-tuned
	
	/**
	 * 
	 * @param speed base speed at which to drive, from -1 to 1
	 * @param timeout number of seconds to drive for
	 */
    public DriveStraightCommand(double speed, double timeout) {
    	leftSpeed = speed;
    	rightSpeed = speed;
    	baseSpeed = speed;
    	setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.m_drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	leftSpeed = baseSpeed;
    	rightSpeed = baseSpeed;
    	angleOffset = Robot.m_drivetrain.getGyroAngle();
    	
    	//Subtract (angle * KP) speed from the side that it's turning away from
    	if(angleOffset < 0){
    		rightSpeed -= angleOffset * KP;
    	}
    	else{
    		leftSpeed -= angleOffset * KP;
    	}
    	
    	Robot.m_drivetrain.tankDrive(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.m_drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
