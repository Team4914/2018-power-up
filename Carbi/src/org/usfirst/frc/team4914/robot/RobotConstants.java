package org.usfirst.frc.team4914.robot;

public class RobotConstants {
	
	// orientations of all three game objectives, with either 'L' or 'R'
	public static char ortnSwitch = ' ';
	public static char ortnScale = ' ';
	public static char ortnOppSwitch = ' ';
	
	// autonomous period constants
	public static final double autoBaselineSpeed = 0.25;
	public static final double autoBaselineTimeout = 4; // timeout in seconds
	
	public static final double[][] autoLeftSwitchWaypoints = new double[][]{
		{0, 162},
		{30, 162},
		{30, 129},
		{60, 129},
		{58, 129}
	};
	
	public static final double[][] autoRightSwitchWaypoints = new double[][]{
		{0, 162},
		{30, 162},
		{30, 195},
		{60, 195},
		{58, 195}
	};
	
	// Intake speed constants
	public static final double intakeSpeed = 1;
	
}
