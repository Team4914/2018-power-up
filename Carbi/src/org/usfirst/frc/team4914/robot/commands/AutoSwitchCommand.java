package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSwitchCommand extends CommandGroup {

    public AutoSwitchCommand() {
    	
    	requires(Robot.m_drivetrain);
    	requires(Robot.m_intake);
    	// requires(Robot.m_lift);
    	
    	if (RobotConstants.ortnSwitch == 'L') { // drive to left switch
    		// run left switch motion profile
    		addSequential(new AutoSmoothPath(RobotConstants.autoLeftSWaypoints, 3.5));
    	} else { // drive to right switch
    		// run right switch motion profile
    		addSequential(new AutoSmoothPath(RobotConstants.autoRightSWaypoints, 3.5));
    	}

		addSequential(new DriveStraightCommand(-0.3, 0.5));
		addSequential(new AutoTimedSpitCubeCommand(2));
    }
}
