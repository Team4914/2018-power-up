/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4914.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;
import org.usfirst.frc.team4914.robot.RobotMap;
import org.usfirst.frc.team4914.robot.commands.*;

/**
 * 
 */
public class Lift extends Subsystem {
	
	private final Compressor compressor = RobotMap.liftCompressor;
	private final DoubleSolenoid doubleSolenoid = RobotMap.liftDoubleSolenoid;
	private final VictorSP victor = RobotMap.liftTalon;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public DoubleSolenoid.Value getDoubleSolenoid() {
		return doubleSolenoid.get();
	}
	
	/** 
	 * Extend lift piston
	 * 
	 * @param isExtended
	 */
	public void setExtension(boolean isExtended){
		if(isExtended){
			doubleSolenoid.set(Value.kForward);
		}
		else {
			doubleSolenoid.set(Value.kReverse);
		}
	}
	
	/**
	 * Sets speed of victor controller
	 */
	public void setSpeed(double speed){
		victor.set(Robot.safety(speed, 1));
	}
	/**
	 * Toggles the piston
	 */
	public void toggleExtension() {
		if (doubleSolenoid.get() == Value.kForward) {
			doubleSolenoid.set(Value.kReverse);
		} else {
			doubleSolenoid.set(Value.kForward);
		}
	}
	
	
	public void startCompressor(){
		compressor.start();
	}
	
	public void stopCompressor() {
		compressor.stop();
	}
	
	public void stop(){
		// compressor.stop();
		doubleSolenoid.set(Value.kOff);
		stopMotor();
	}

	public void stopMotor() {
		setSpeed(0);
	}
}
