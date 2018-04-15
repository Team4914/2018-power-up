package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStraightDropoff extends CommandGroup {

    public AutoStraightDropoff() {

    	requires(Robot.m_drivetrain);
    	requires(Robot.m_intake);
    	
    	// drive past baseline
    	addSequential(new AutoDrivePathCmd("baselineRight"));
    	
    	addSequential(new OuttakeTimedCmd(3));
    	
    	// dump cube if appropriate
    	// addSequential(new AutoConditionalDropoff("baselineLeft"));
    	
    	/*
    	if (RobotConstants.ortnSwitch == 'R') { 
    		
    		// right side of switch is home switch
    		
    		// run right S-path profile and spit out cube
    		addSequential(new DrivePathCmd(RobotConstants.k_SwitchAutoRightFPPWaypoints, 4));
    		addSequential(new DrivePathCmd(RobotConstants.autoRightBaselineWaypoints, 1));
    		
    		// drive back a bit and spit out cube
    		addSequential(new DriveStraightCmd(-0.3, 0.5));
    		addSequential(new OuttakeTimedCmd(2));
    		
    	} else { // drive to right switch
    		// left (farther) side of switch is home switch
    		// run drive forward baseline
    		addSequential(new DrivePathCmd(RobotConstants.k_SwitchAutoRightFPPWaypoints, 4));
    	}
    	*/
    }
}
