package org.usfirst.frc.team4914.robot.subsystems;

import org.usfirst.frc.team4914.robot.Robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class MotorLift extends PIDSubsystem {
	
	private TalonSRX _talon = RobotMap.liftMotor;

    // Initialize your subsystem here
    public MotorLift() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("MotorLift", 0.01, 0.0, 0.0);
    	
    	// set to brake mode in neutral
    	_talon.setNeutralMode(NeutralMode.Brake);
    	
    	// tolerance of reaching setpoint
    	setAbsoluteTolerance(5);
    	// not continuous (i.e. full circle)
    	getPIDController().setContinuous(false);
    	// set output range of controller to that accepted of motor controller
    	setOutputRange(-1, 1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;	
    	
        return _talon.getSensorCollection().getQuadraturePosition();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	// _talon.set(ControlMode., arg1);
    }
}
