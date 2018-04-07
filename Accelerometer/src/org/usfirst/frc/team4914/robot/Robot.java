/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4914.robot;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class Robot extends SampleRobot{
	ADXL345_I2C accel;
	BuiltInAccelerometer builtAccel;
	SPI gyro;
	long thing;
	
	double builtOffsetY;
	
	double offsetX;
	double offsetY;
	double offsetZ;
	
	double accelerationX;
	double accelerationY;
	double accelerationZ;

	double builtAccelX;
	double builtAccelY;
	double builtAccelZ;
	
	double velocityX = 0;
	double velocityY = 0;
	double velocityZ = 0;
	
	double posX = 0;
	double posY = 0;
	double posZ = 0;
	
	public Robot() {
	}
	
	@Override
	public void robotInit(){
		accel = new ADXL345_I2C(I2C.Port.kOnboard, Accelerometer.Range.k4G);
		gyro = new SPI(Port.kOnboardCS0);
		builtAccel = new BuiltInAccelerometer();
	}
	
	@Override
	public void operatorControl() {
		offsetX = accel.getX();
		offsetY = accel.getY();
		offsetZ = accel.getZ();
		
		builtOffsetY = builtAccel.getY();
		while(isEnabled()){
			thing = gyro.getAccumulatorValue();
			
			accelerationX = accel.getX() - offsetX;
			accelerationY = accel.getY() - offsetY;
			accelerationZ = accel.getZ() - offsetZ;
			
			builtAccelX = builtAccel.getX();
			builtAccelY = builtAccel.getY() - builtOffsetY;
			builtAccelZ = builtAccel.getZ();
			
			velocityX += accelerationX * 0.01;
			velocityY += accelerationY * 0.01;
			velocityZ += accelerationZ * 0.01;
			
			posX += velocityX * 0.01;
			posY += velocityY * 0.01;
			posZ += velocityZ * 0.01;
			
			velocityX = 0;
			velocityY = 0;
			velocityZ = 0;
			
			//System.out.println("thing:" + thing);
			
			//System.out.println("X: " + accelerationX);
			System.out.println("Y: " + builtAccelY);
			System.out.println("X: " + accelerationX * -1);
			//System.out.println("Z: " + posZ);
			Timer.delay(0.01);
			
			//System.out.println(posX);
		}
	}
}
