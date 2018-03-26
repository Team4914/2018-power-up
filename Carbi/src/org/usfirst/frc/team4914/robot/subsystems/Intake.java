// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team4914.robot.subsystems;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotMap;
import org.usfirst.frc.team4914.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


/**
 *
 */
public class Intake extends Subsystem {

	private final Spark intakeLeft = RobotMap.intakeLeft
	private final Spark intakeRight = RobotMap.intakeRight;
	
	private final DoubleSolenoid intakeDoubleSolenoid = RobotMap.intakeDoubleSolenoid;
	
	public DoubleSolenoid.Value getDoubleSolenoid() {
		return intakeDoubleSolenoid.get();
	}
	
    @Override
    public void initDefaultCommand() {

    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
    /**
     * 
     * @param speed from -1 to 1
     */
    public void setLeft(double speed) {
    	speed = Robot.safety(speed, 1);
    	intakeLeft.set(speed);
    }
    
    /**
     * 
     * @param speed from -1 to 1
     */
    public void setRight(double speed) {
    	speed = Robot.safety(speed, 1);
    	intakeRight.set(speed);
    }
    
    /**
     * 
     * @param speed from -1 to 1
     */
    public void set(double speed) {
    	setLeft(speed);
    	setRight(speed);
    }
    
    /**
     * 
     * @param leftSpeed speed from -1 to 1
     * @param rightSpeed speed from -1 to 1
     */
    public void set(double leftSpeed, double rightSpeed) {
    	setLeft(leftSpeed);
    	setRight(rightSpeed);
    }
    /** 
	 * @param isExtended
	 */
	public void setExtension(boolean isExtended){
		if(isExtended){
			intakeDoubleSolenoid.set(Value.kForward);
		}
		else{
			intakeDoubleSolenoid.set(Value.kReverse);
		}
	}
    /**
     * Stops all intake motors.
     */
    public void stop() {
    	set(0);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

