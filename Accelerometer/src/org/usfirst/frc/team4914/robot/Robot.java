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
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;

public class Robot extends SampleRobot{
	ADXL345_I2C accel;
	BuiltInAccelerometer builtAccel;
	SPI gyro;
	long thing;
	
	double builtAverageY;
	
	double averageX;
	double averageY;
	double averageZ;
	
	double accelerationX;
	double accelerationY;
	double accelerationZ;

	double builtAccelX;
	double builtAccelY;
	double builtAccelZ;
	
	double builtVelocityY = 0;
	double builtPosY = 0;
	
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
		builtAccel.setRange(Range.k2G);
	}
	
	@Override
	public void operatorControl() {
		
		double offsetY = builtAccel.getY();
		
		averageX = accel.getX();
		averageY = accel.getY();
		averageZ = accel.getZ();
		
		builtAverageY = builtAccel.getY();
		while(isEnabled()){
			thing = gyro.getAccumulatorValue();
			
			accelerationX = accel.getX() - averageX;
			accelerationY = accel.getY() - averageY;
			accelerationZ = accel.getZ() - averageZ;
			
			builtAccelX = builtAccel.getX();
			builtAccelY = (builtAccel.getY() - builtAverageY) - offsetY;
			builtAccelZ = builtAccel.getZ();
			
			velocityX += accelerationX * 0.001;
			velocityY += accelerationY * 0.001;
			velocityZ += accelerationZ * 0.001;
			
			posX += velocityX * 0.001;
			posY += velocityY * 0.001;
			posZ += velocityZ * 0.001;
			
			builtVelocityY += builtAccelY * 0.00125;
			builtPosY += builtVelocityY * 0.00125;
			
			//end
			averageX = accelerationX * 0.1 + 0.9 * averageX;
			averageY = accelerationY * 0.1 + 0.9 * averageY;			
			averageZ = accelerationZ * 0.1 + 0.9 * averageZ;
			
			builtAverageY = builtAccelY * 0.01 + 0.99 * builtAverageY;
			//System.out.println("thing:" + thing);
			
			//System.out.println("X: " + accelerationX);
			//System.out.println("Y: " + builtAccelY);
			System.out.println("Y: " + builtPosY);
			//System.out.println("Z: " + posZ);
			Timer.delay(0.00125);
			
			//System.out.println(posX);
		}
	}
}
