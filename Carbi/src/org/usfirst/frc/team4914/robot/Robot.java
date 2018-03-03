/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4914.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4914.robot.commands.*;
import org.usfirst.frc.team4914.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static double driveSpeedLeft;
	public static double driveSpeedRight;

	public static Drivetrain m_drivetrain;
	public static Intake m_intake;
	public static Lift m_lift;
	public static Climber m_climber;
	// public static Climber m_climber;
	
	public static OI m_oi;

	private static int testPWM = 1;
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		
		// This block of code initializes all subsystems to local member variables named m_subsystem
		m_drivetrain = new Drivetrain();
		m_intake = new Intake();
		m_lift = new Lift();
		m_climber = new Climber();
		
		// RobotMap.liftCompressor.setClosedLoopControl(true);
		m_lift.startCompressor();
		
		m_oi = new OI();
		
		// construct autonomous chooser
		m_chooser.addDefault("Switch Auto", new AutoSwitchCommand());
		m_chooser.addObject("Left Baseline Auto", new AutoBaselineLeftCommand());
		m_chooser.addObject("Right Baseline Auto", new AutoBaselineRightCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		// safety code in here
		Robot.m_drivetrain.stop();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		// set double solenoid in reverse
		m_lift.setExtension(false);
		
		// get field orientation, "game specific message"
		// from the switch closest to the home driverstation, string will look like "LRL"
		String GSM;
		try {
			GSM = DriverStation.getInstance().getGameSpecificMessage();
		} catch (Exception e) {
			System.out.println("No Game Specific Message!");
			GSM = "RRR";
		}
		// parse string
		RobotConstants.ortnSwitch = GSM.charAt(0);
		RobotConstants.ortnScale = GSM.charAt(1);
		RobotConstants.ortnOppSwitch = GSM.charAt(2);
		
		// get selected command
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		// set double solenoid in reverse
		m_lift.setExtension(false);
				
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		operateTankDrive();
		operateIntake();
		
	}
	
	private void operateIntake() {
		// if the outtake command isn't overriding it
		if (Robot.m_oi.coBumperLeft.get() == false && 
				Robot.m_oi.coBumperRight.get() == false &&
				Robot.m_oi.mainB.get() == false) {
			Robot.m_intake.set(Robot.m_oi.getCoTLeft(), 
					Robot.m_oi.getCoTRight());
		}
	}
	
	private void operateTankDrive() {
		driveSpeedLeft += Robot.m_oi.getMainYLeft();
		driveSpeedRight += Robot.m_oi.getMainYRight();
		
		driveSpeedLeft += 0.5*Robot.m_oi.getCoYLeft();
		driveSpeedRight += 0.5*Robot.m_oi.getCoYRight();
		
		Robot.m_drivetrain.tankDrive(driveSpeedLeft, driveSpeedRight);
		
		driveSpeedLeft = 0;
		driveSpeedRight = 0;
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		
		switch(testPWM) {
		case 1: 
			System.out.println(testPWM + ":" + "Right intake.");
			m_intake.setRight(0.5);
			break;
		case 2: 
			System.out.println(testPWM + ":" + "Left intake.");
			m_intake.setLeft(0.5);
			break;
		case 3: 
			System.out.println(testPWM + ":" + "Right single motor.");
			m_drivetrain.setRightSingle(0.2);
			break;
		case 5: 
			System.out.println(testPWM + ":" + "Right double motor.");
			m_drivetrain.setRightDouble(0.2);
			break;
		case 8: 
			System.out.println(testPWM + ":" + "Left double motor.");
			m_drivetrain.setLeftDouble(0.2);
			break;
		case 9: 
			System.out.println(testPWM + ":" + "Left single motor.");
			m_drivetrain.setLeftSingle(0.2);
			break;
		default:
			System.out.println(testPWM + ": Not linked to motor.");
		}
		
		Timer.delay(2);
		
		while(m_oi.mainBumperRight.get() || Robot.m_oi.coBumperRight.get()) {
			//Timer.delay(0.5);
			//Doesn't need a delay, as long as button is held down motor will continue
		}
		
		testPWM++;
		stopAll();
		
		//check if test is done?
	}
	
	/**
	 * Stops all drivetrain and intake motors
	 */
	public static void stopAll() {
		m_intake.stop();
		m_drivetrain.stop();
	}
	
	/**
	 * Keeps motor controller input values at safe values
	 * 
	 * @param input
	 * @param threshold
	 * @return
	 */
	public static double safety(double input, double threshold) {
		threshold = Math.abs(threshold);
		if (input < -threshold) {
			input = -threshold;
		} else if (input > threshold) {
			input = threshold;
		}
		
		return input;
	}
}
