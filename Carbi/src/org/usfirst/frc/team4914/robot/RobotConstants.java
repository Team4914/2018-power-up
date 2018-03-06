package org.usfirst.frc.team4914.robot;

public class RobotConstants {
	
	// orientations of all three game objectives, with either 'L' or 'R'
	public static char ortnSwitch = ' ';
	public static char ortnScale = ' ';
	public static char ortnOppSwitch = ' ';
	
	// autonomous period constants
	public static final double autoBaselineSpeed = 0.25;
	public static final double autoBaselineTimeout = 4; // timeout in seconds
	
	// autonomous period drive waypoints
	public static final double[][] autoLeftSWaypoints = new double[][]{
		{0, 0},
		{30, 0},
		{30, -30},
		{58, -30}
	};
	
	public static final double[][] autoRightSWaypoints = new double[][]{
		{0, 0},
		{30, 0},
		{30, 30},
		{58, 30}
	};
	
	public static final double[][] autoLeftBaselineWaypoints = new double[][]{
		{60, -33},
		{80, -33},
		{80, -15}
	};
	
	public static final double[][] autoRightBaselineWaypoints = new double[][]{
		{60, 33},
		{80, 33},
		{80, 15}
	};
	
	public static final double[][] autoStraightWaypoints = new double[][] {
		{0, 0},
		{100, 0}
	};
	
	// co-driver reduction multiplier
	public static final double coDriveMultiplier = 0.6;
	
	// Intake speed constants
	public static final double intakeSpeed = 1;
	
}
