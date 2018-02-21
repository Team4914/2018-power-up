/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4914.robot;

import org.usfirst.frc.team4914.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
    public JoystickButton B;
    public JoystickButton X;
    public JoystickButton Y;
    public JoystickButton leftTrigger;
    public JoystickButton rightTrigger;
    public Joystick driverJoystick;

    public OI() {

        driverJoystick = new Joystick(0);
        
        B = new JoystickButton(driverJoystick, 2);
        B.whileHeld(new SpitCubeCommand());
        
        X = new JoystickButton(driverJoystick, 3);
        X.whileHeld(new RunWinchCommand());
        
        Y = new JoystickButton(driverJoystick, 4);
        Y.whileHeld(new LoosenWinchCommand());
        
        leftTrigger = new JoystickButton(driverJoystick, 5);
        leftTrigger.whenPressed(new PullPinCommand());
        
        rightTrigger = new JoystickButton(driverJoystick, 6);
        rightTrigger.whenPressed(new RaiseLiftCommand());
        rightTrigger.whenReleased(new LowerLiftCommand());

        // joystickButton1 = new JoystickButton(driverJoystick, 1);
        // joystickButton1.whenPressed(new AutonomousCommand());

        // SmartDashboardo fields
        SmartDashboard.putNumber("Drive Straight Speed", 0);
        SmartDashboard.putNumber("Drive Straight Timeout", 0);

        // SmartDashboard Buttons
        SmartDashboard.putData("Baseline Auto", new AutoBaselineCommand());
        SmartDashboard.putData("Switch Auto", new AutoSwitchCommand());
        SmartDashboard.putData("Drive Straight", new DriveStraightCommand(
        		SmartDashboard.getNumber("Drive Straight Speed", 0),
        		SmartDashboard.getNumber("Drive Straight Timeout", 0)));
    }

    public Joystick getDriverJoystick() {
        return driverJoystick;
    }
    
    public double getPrimaryLJ() {
    	return driverJoystick.getRawAxis(1);
    }
    
    public double getPrimaryRJ() {
    	return driverJoystick.getRawAxis(5);
    }
    
    public double getLT() {
    	return driverJoystick.getRawAxis(2);	
    }
    
    public double getRT() {
    	return driverJoystick.getRawAxis(3);   	
    }
}
