/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4914.robot.subsystems;

import org.usfirst.frc.team4914.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Kinematics extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	//Sensors
	private final ADXL345_I2C accel = RobotMap.accelerometer;
	private final ADXRS450_Gyro gyro = RobotMap.gyro;
	
	//Measurements
	double xOffset;
	double yOffset;
	double zOffset;
	
	double xAccel;
	double yAccel;
	double zAccel;
	
	double xVelocity;
	double yVelocity;
	double zVelocity;
	
	double xPos;
	double yPos;
	double zPos;
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
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
}
