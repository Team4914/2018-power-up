package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The robot begins on the left side of the home switch
 */
public class AutoBaseline extends CommandGroup {

    public AutoBaseline() {

    	requires(Robot.m_drivetrain);
    	requires(Robot.m_intake);
    	
    	// drive past baseline
    	addSequential(new AutoDrivePathCmd("baselineLeft"));
    	
    	// dump cube if appropriate
    	addSequential(new AutoConditionalDropoff("baselineLeft"));
    	
    	/*
    	if (RobotConstants.ortnSwitch == 'L') {
    		
    		// left side of switch is home switch
    		
    		// run left S-path profile
    		addSequential(new DrivePathCmd(RobotConstants.k_SwitchAutoLeftFPPWaypoints, 4));
    		addSequential(new DrivePathCmd(RobotConstants.autoLeftBaselineWaypoints, 1));
    		
    		// drive back a bit and spit out cube
    		addSequential(new DriveStraightCmd(-0.3, 0.5));
    		addSequential(new OuttakeTimedCmd(2));
    		
    	} else { // drive to right switch
    		// right (farther) side of switch is home switch
    		// run drive forward baseline
    		addSequential(new DrivePathCmd(RobotConstants.k_SwitchAutoLeftFPPWaypoints, 4));
    	}
    	*/
    	
    }
}
