/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4914.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static Gyro gyro;
    public static VictorSP leftDouble;
    public static VictorSP leftSingle;
    public static VictorSP rightDouble;
    public static VictorSP rightSingle;
    
	public static void init() {
		
		leftDouble = new VictorSP(8);
		leftDouble.setInverted(false);
		
		leftSingle = new VictorSP(9);
		leftSingle.setInverted(false);
		
		rightDouble = new VictorSP(5);
		rightDouble.setInverted(true);
		
		rightSingle = new VictorSP(3);
		rightSingle.setInverted(true);
		
		gyro = new ADXRS450_Gyro(Port.kOnboardCS0);

    }
}
