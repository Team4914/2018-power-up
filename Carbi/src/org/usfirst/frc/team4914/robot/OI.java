/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4914.robot;

import org.usfirst.frc.team4914.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
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
	
	/**
	 * Represents a digital button on an Xbox controller.
	 */
	public enum XboxButton {
	    kBumperLeft(5),
	    kBumperRight(6),
	    kStickLeft(9),
	    kStickRight(10),
	    kA(1),
	    kB(2),
	    kX(3),
	    kY(4),
	    kBack(7),
	    kStart(8);
	
	    @SuppressWarnings("MemberName")
	    private int value;
	
	    XboxButton(int value) {
	      this.value = value;
	    }
	}
	
	/**
	 * Represents an axis on an Xbox controller
	 */
	public enum XboxAxis {
		kYLeft(1),
		kYRight(5),
		kXLeft(0),
		kXRight(4),
		kTLeft(2),
		kTRight(3);
		
		@SuppressWarnings("MemberName")
		private int value;
		
		XboxAxis(int value) {
			this.value = value;
		}
	}
	
	/*
	 * Joystick declarations
	 */
    public Joystick mainJoystick;
    public JoystickButton mainA, mainB, mainX, mainY, 
    	mainBack, mainStart, mainBumperLeft, mainBumperRight, 
    	mainStickLeft, mainStickRight;
    public Joystick coJoystick;
    public JoystickButton coA, coB, coX, coY, 
    	coBack, coStart, coBumperLeft, coBumperRight, 
    	coStickLeft, coStickRight;
    

    public OI() {
    	
    	initMainJoystick();
    	// initCoJoystick();
    	
    	/*
    	 * This is where you assign functions to the main joystick controller
    	 */
    	mainB.whileHeld(new SpitCubeCommand());
        
    	mainX.whileHeld(new RunWinchCommand());
        
        mainY.whileHeld(new LoosenWinchCommand());
        
        mainBumperLeft.whenPressed(new PullPinCommand());
        
        mainBumperRight.whenPressed(new ToggleLiftPistonCommand());
        
        
        /*
         * This is where you assign functions to the co joystick controller
         */

        // SmartDashboard fields
        SmartDashboard.putNumber("Drive Straight Speed", 0);
        SmartDashboard.putNumber("Drive Straight Timeout", 0);

        // SmartDashboard Buttons
        SmartDashboard.putData("Baseline Auto", new AutoBaselineCommand());
        SmartDashboard.putData("Switch Auto", new AutoSwitchCommand());
        SmartDashboard.putData("Drive Straight", new DriveStraightCommand(
        		SmartDashboard.getNumber("Drive Straight Speed", 0),
        		SmartDashboard.getNumber("Drive Straight Timeout", 0)));
    }
    
    private void initMainJoystick() {
    	
    	mainJoystick = new Joystick(0);
    	
    	Joystick thisJoystick = mainJoystick;
        
    	mainA = new JoystickButton(thisJoystick, XboxButton.kA.value);
        mainB = new JoystickButton(thisJoystick, XboxButton.kB.value);
        mainX = new JoystickButton(thisJoystick, XboxButton.kX.value);
        mainY = new JoystickButton(thisJoystick, XboxButton.kY.value);
        mainBumperLeft = new JoystickButton(thisJoystick, XboxButton.kBumperLeft.value);
        mainBumperRight = new JoystickButton(thisJoystick, XboxButton.kBumperRight.value);
        mainBack = new JoystickButton(thisJoystick, XboxButton.kBack.value);
        mainStart = new JoystickButton(thisJoystick, XboxButton.kStart.value);
        mainStickLeft = new JoystickButton(thisJoystick, XboxButton.kStickLeft.value);
        mainStickRight = new JoystickButton(thisJoystick, XboxButton.kStickRight.value);
    }
    

    
    private void initCoJoystick() {
    	
    	coJoystick = new Joystick(1);
    	
    	Joystick thisJoystick = coJoystick;
        
    	coA = new JoystickButton(thisJoystick, XboxButton.kA.value);
        coB = new JoystickButton(thisJoystick, XboxButton.kB.value);
        coX = new JoystickButton(thisJoystick, XboxButton.kX.value);
        coY = new JoystickButton(thisJoystick, XboxButton.kY.value);
        coBumperLeft = new JoystickButton(thisJoystick, XboxButton.kBumperLeft.value);
        coBumperRight = new JoystickButton(thisJoystick, XboxButton.kBumperRight.value);
        coBack = new JoystickButton(thisJoystick, XboxButton.kBack.value);
        coStart = new JoystickButton(thisJoystick, XboxButton.kStart.value);
        coStickLeft = new JoystickButton(thisJoystick, XboxButton.kStickLeft.value);
        coStickRight = new JoystickButton(thisJoystick, XboxButton.kStickRight.value);
    }

    public Joystick getMainJoystick() {
        return mainJoystick;
    }

    public Joystick getCoJoystick() {
    	return coJoystick;
    }
    
    public double getMainYLeft() {
    	return mainJoystick.getRawAxis(XboxAxis.kYLeft.value);
    }
    
    public double getMainYRight() {
    	return mainJoystick.getRawAxis(XboxAxis.kYRight.value);
    }
    
    public double getMainTLeft() {
    	return mainJoystick.getRawAxis(XboxAxis.kTLeft.value);
    }
    
    public double getMainTRight() {
    	return mainJoystick.getRawAxis(XboxAxis.kTRight.value);
    }
}
