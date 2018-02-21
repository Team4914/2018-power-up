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
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.VictorSP;


/**
 *
 */
public class Drivetrain extends Subsystem {

	private final ADXRS450_Gyro gyro = RobotMap.gyro;
    private final VictorSP leftDouble = RobotMap.leftDouble;
    private final VictorSP leftSingle = RobotMap.leftSingle;
    private final VictorSP rightDouble = RobotMap.rightDouble;
    private final VictorSP rightSingle = RobotMap.rightSingle;

    @Override
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    	
    }
    
    /**
     * 
     * @param leftSpeed
     * @param rightSpeed
     */
    public void tankDrive(double leftSpeed, double rightSpeed) {
    	setLeft(-leftSpeed);
    	setRight(-rightSpeed);
    }
    
    /**
     * 
     * @param speed left side speed, from -1 to 1
     */
    public void setLeft(double speed) {
    	speed = Robot.safety(speed, 1);
    	leftDouble.set(speed);
    	leftSingle.set(speed);
    }
    
    /**
     * 
     * @param speed right side speed, from -1 to 1
     */
    public void setRight(double speed) {
    	speed = Robot.safety(speed, 1);
    	rightDouble.set(speed);
    	rightSingle.set(speed);
    }
    
    /**
     * Returns heading of gyrometer in degrees. Value may be positive 
     * 	or negative depending on whether it has crossed over the 0 reading.
     * @return heading of gyrometer in degrees
     */
    public double getGyroAngle(){
    	return gyro.getAngle();
    }
    
    /**
     * Resets gyrometer to a reading of 0
     */
    public void resetGyro(){
    	gyro.reset();
    }
    
    /**
     * Stops all drivetrain motors
     */
    public void stop() {
    	leftDouble.set(0);
    	leftSingle.set(0);
    	rightDouble.set(0);
    	rightSingle.set(0);
    }

}

