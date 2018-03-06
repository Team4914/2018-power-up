package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The robot begins on the left side of the home switch
 */
public class AutoBaselineLeftCommand extends CommandGroup {

    public AutoBaselineLeftCommand() {

    	requires(Robot.m_drivetrain);
    	requires(Robot.m_intake);
    	
    	if (RobotConstants.ortnSwitch == 'L') { 
    		
    		// left side of switch is home switch
    		
    		// run left S-path profile
    		addSequential(new AutoDrivePath(RobotConstants.k_SwitchAutoLeftFPPWaypoints, 4));
    		addSequential(new AutoDrivePath(RobotConstants.autoLeftBaselineWaypoints, 1));
    		
    		// drive back a bit and spit out cube
    		addSequential(new DriveStraightCommand(-0.3, 0.5));
    		addSequential(new TimedOuttakeCommand(2));
    		
    	} else { // drive to right switch
    		// right (farther) side of switch is home switch
    		// run drive forward baseline
    		addSequential(new AutoDrivePath(RobotConstants.k_SwitchAutoLeftFPPWaypoints, 4));
    	}
    	
    }
}
