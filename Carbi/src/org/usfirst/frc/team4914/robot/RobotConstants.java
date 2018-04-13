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
	
	// duration of entire drive path
	public static final double k_SwitchAutoFPPTime = 4;
	
	// autonomous period drive waypoints
	public static final double[][] k_SwitchAutoLeftFPPWaypoints = new double[][]{
		{0, 0},
		{30, 0},
		{30, -20},
		{58, -60}
	};
	
	public static final double[][] k_SwitchAutoRightFPPWaypoints = new double[][]{
		{0, 0},
		{30, 0},
		{30, 20},
		{58, 60}
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
	
	public static final double[][] k_BaselineAutoStraightWaypoints = new double[][] {
		{0, 0},
		{80, 0}
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
	public static final double k_outtakeSpeed = -1;
	
/* Lift CAN PID control */
	
	public static final int k_liftTopSetpoint = 642000;
	public static final int k_liftMiddleSetpoint = 513000;
	public static final int k_liftBottomSetpoint = 0;
	
	public static final int k_quadPerInches = 15287;
	
	public static char isLifting = 'b';
	
	public static final double k_P = 0.000007;
	public static final double k_epsilon = 0.5*k_quadPerInches;
	
}
