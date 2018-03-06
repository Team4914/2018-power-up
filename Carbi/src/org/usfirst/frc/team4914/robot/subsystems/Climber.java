package org.usfirst.frc.team4914.robot.subsystems;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	
	private final Servo servo = RobotMap.servo;
	private final Talon winch = RobotMap.winch;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Pulls pin out of the climber PVC using the servo
     */
    public void pullPin() {
    	double initial = servo.getAngle();
    	servo.set(initial + 180);
    }
    
    /**
     * Sets winch speed
     * @param speed speed at which to run winch, from -1 to 1
     */
    public void set(double speed) {
    	speed = Robot.safety(speed, 1);
    	winch.set(speed);
    }
}

