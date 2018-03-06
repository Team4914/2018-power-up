package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBaselineRightCommand extends CommandGroup {

    public AutoBaselineRightCommand() {

    	requires(Robot.m_drivetrain);
    	requires(Robot.m_intake);
    	
    	if (RobotConstants.ortnSwitch == 'R') { 
    		
    		// right side of switch is home switch
    		
    		// run right S-path profile and spit out cube
    		addSequential(new AutoDrivePath(RobotConstants.k_SwitchAutoRightFPPWaypoints, 4));
    		addSequential(new AutoDrivePath(RobotConstants.autoRightBaselineWaypoints, 1));
    		
    		// drive back a bit and spit out cube
    		addSequential(new DriveStraightCommand(-0.3, 0.5));
    		addSequential(new TimedOuttakeCommand(2));
    		
    	} else { // drive to right switch
    		// left (farther) side of switch is home switch
    		// run drive forward baseline
    		addSequential(new AutoDrivePath(RobotConstants.k_SwitchAutoRightFPPWaypoints, 4));
    	}
    }
}
