package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSwitchCmd extends CommandGroup {

    public AutoSwitchCmd() {
    	
    	requires(Robot.m_drivetrain);
    	requires(Robot.m_intake);
    	requires(Robot.m_lift);
    	
    	// drive to owned switch
    	addSequential(new AutoDrivePathCmd("switch"));
    	
    	// drive back slightly
 		addSequential(new DriveStraightCmd(-0.3, 0.5));
		// lift lift
		addSequential(new LiftToggleCmd());	
		addParallel(new OuttakeTimedCmd(1.5));
		
    }
}
