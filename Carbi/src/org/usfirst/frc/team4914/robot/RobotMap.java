/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4914.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.Servo;
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
	
	// Drivetrain actuators
	public static ADXRS450_Gyro gyro;
    public static VictorSP leftDouble;
    public static VictorSP leftSingle;
    public static VictorSP rightDouble;
    public static VictorSP rightSingle;
    
    // Intake actuators
    public static Spark intakeLeft;
    public static Spark intakeRight;
    
    // Pneumatic actuators
    public static Compressor liftCompressor;
    public static DoubleSolenoid liftDoubleSolenoid;
    
    public static DoubleSolenoid intakeDoubleSolenoid;
    
    public static DoubleSolenoid climbDoubleSolenoid;
    
    // Lift actuators
    public static Servo servo;
    public static Talon winch;

    
	public static void init() {
		
		// Drivetrain
		
		leftDouble = new VictorSP(1);
		leftDouble.setInverted(false);
		
		leftSingle = new VictorSP(8);
		leftSingle.setInverted(false);
		
		rightDouble = new VictorSP(7);
		rightDouble.setInverted(true);
		
		rightSingle = new VictorSP(9);
		rightSingle.setInverted(true);
		
		gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
		
		// Pneumatics
		
		liftCompressor = new Compressor(0);
		
		//Start compressor as off
		liftDoubleSolenoid = new DoubleSolenoid(1, 2);
		
		intakeDoubleSolenoid = new DoubleSolenoid(3, 4);
		
		climbDoubleSolenoid = new DoubleSolenoid(5, 6);
		
		// Intake
		
		intakeLeft = new Spark(6);
		intakeLeft.setInverted(true);
		
		intakeRight = new Spark(5);
		intakeRight.setInverted(false);
		
		// Climber
		
		servo = new Servo(7);
		
		winch = new Talon(6);
		winch.setInverted(true);
		
    }
}
