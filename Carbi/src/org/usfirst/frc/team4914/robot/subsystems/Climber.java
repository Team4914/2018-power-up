package org.usfirst.frc.team4914.robot.subsystems;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	
	private final Talon winch = RobotMap.winch;
	
	private final DoubleSolenoid climbDoubleSolenoid = RobotMap.climbDoubleSolenoid;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public DoubleSolenoid.Value getDoubleSolenoid() {
		return climbDoubleSolenoid.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Sets winch speed
     * @param speed speed at which to run winch, from -1 to 1
     */
    public void set(double speed) {
    	speed = Robot.safety(speed, 1);
    	winch.set(speed);
    	
    }
    /** 
	 * @param isExtended
	 */
	public void setExtension(boolean isExtended){
		if(isExtended){
			climbDoubleSolenoid.set(Value.kForward);
		}
		else{
			climbDoubleSolenoid.set(Value.kReverse);
		}
	}
}

