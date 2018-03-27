package org.usfirst.frc.team4914.robot;

public class RobotConstants {
	
/* GSM */
	// orientations of all three game objectives, with either 'L' or 'R'
	public static char ortnSwitch = ' ';
	public static char ortnScale = ' ';
	public static char ortnOppSwitch = ' ';
	
/* Falcon Path generator */
	
	// period of control; seconds
	public static final double k_FPPTimeStep = 0.1;
	// distance between left and right tracks; inches
	public static final double k_FPPRobotTrackWidth = 28;
	
/* Switch Autonomous */
	
	// duration of entire drive path for switch
	public static final double k_SwitchAutoFPPTime = 2;
	
	// autonomous period drive waypoints
	public static final double[][] k_SwitchAutoLeftFPPWaypoints = new double[][]{
		{0, 0},
		{30, 0},
		{30, -30},
		{58, -30}
	};
	
	public static final double[][] k_SwitchAutoRightFPPWaypoints = new double[][]{
		{0, 0},
		{30, 0},
		{30, 30},
		{58, 30}
	};
	
	// deprecated
	public static final double[][] autoLeftBaselineWaypoints = new double[][]{
		{60, -33},
		{80, -33},
		{80, -15}
	};
	
	// deprecated
	public static final double[][] autoRightBaselineWaypoints = new double[][]{
		{60, 33},
		{80, 33},
		{80, 15}
	};
	
/* Baseline autonomous */
	
	// duration of drive path
	public static final double k_BaselineAutoFPPTime = 4;
	
	// waypoints
	public static final double[][] k_BaselineAutoFPPWaypoints = new double[][] {
		{0, 0},
		{100, 0}
	};
	
/* Teleoperated mode */
	
	// co-driver reduction multiplier
	public static final double k_coDriveMultiplier = 0.6;
	
	// outtake speed constants
	public static final double k_outtakeSpeed = 1;
	
}
