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
public class Lift2 extends Subsystem {
	
	private final Compressor compressor = RobotMap.liftCompressor;
	private final DoubleSolenoid doubleSolenoid = RobotMap.liftDoubleSolenoid;
	private final VictorSP talon = RobotMap.liftTalon;

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
	
	/*
	**
	 * Initialize talon closed-loop control
	 *
	public void initTalon() {
		
		// Slot 0 => allowable error = half inch
		talon.configAllowableClosedloopError(0, (int) RobotConstants.k_epsilon, 10);
		// Similarly, Slot 1 
		talon.configAllowableClosedloopError(1, (int) RobotConstants.k_epsilon, 10);
		
		talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		// set forward and backward soft limits
		talon.configForwardSoftLimitThreshold(RobotConstants.k_liftTopSetpoint, 10);
		talon.configReverseSoftLimitThreshold(RobotConstants.k_liftBottomSetpoint, 10);
		// enable soft limits
		talon.configForwardSoftLimitEnable(true, 10);
		talon.configReverseSoftLimitEnable(true, 10);
		// pass false to FORCE OFF the feature. Otherwise the enable flags above are honored
		talon.overrideLimitSwitchesEnable(true);
		
		// set kP of slot 0 PID
		talon.config_kP(0, 0.01, 10);
		// set kP of slot 1 PID
		talon.config_kP(1, 0.01, 10);
		
		talon.setSelectedSensorPosition(0, 0, 10);

		// set feedback coefficient
		// talon.configSelectedFeedbackCoefficient(1000.0/4096.0/10.0, 0, 1);
	}
	
	public void setSoftLimit(boolean setSoft) {
		if (setSoft) {
			talon.overrideLimitSwitchesEnable(true);
		} else {
			talon.overrideLimitSwitchesEnable(false);
		}
	}*/
	
	/**
	 * Set talon encoder to 0
	 */
	/*public void resetQuad() {
		talon.setSelectedSensorPosition(0, 0, 10);
	}*/
	
	/**
	 * Set talon speed
	 * 
	 * @param speed from -1 to 1
	 *//*
    public void setSpeed(double speed) {
    	speed = Robot.safety(speed, 1);
    	talon.set(ControlMode.PercentOutput, speed);
    }*/
    
    /**
     * Set talon position (closed-loop control)
     * 
     * @param pos
     *//*
    public void setPos(double pos) {
    	talon.set(ControlMode.Position, pos);
    }*/
    
    /**
     * @deprecated
     * Lift or lower motor (does not work)
     *//*
    public void toggleMotorExtension() {
    	if (RobotConstants.isLifting == 'b') {
    		// move up
    		talon.selectProfileSlot(0, 0);
    		setPos(RobotConstants.k_liftTopSetpoint);
    		System.out.println("top setpoint");
    	} else {
    		// move down
    		talon.selectProfileSlot(1, 0);
    		setPos(RobotConstants.k_liftBottomSetpoint);
    	}
    	
    	// toggle isLifting
    	// RobotConstants.isLifting = !RobotConstants.isLifting;
    }
    */
    /**
     * Stops talon
     *//*
    public void stopMotor() {
    	setSpeed(0);
    }*/
    
    /**
     * Gets quadrature encoder reading
     *//*
    public double getQuad() {
    	return talon.getSensorCollection().getQuadraturePosition();
    }*/
    
	/**
	 * Toggles the piston
	 *//*
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
	}*/
}
