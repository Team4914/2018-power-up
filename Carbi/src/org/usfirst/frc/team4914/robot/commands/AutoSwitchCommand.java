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
    	
    	// drive to switch
    	addSequential(new AutoDrivePathGSM());

    	// drive back slightly
		addSequential(new DriveStraightCommand(-0.3, 0.5));
		// release cube
		addSequential(new TimedOuttakeCommand(0.5));
		// lift lift
		addSequential(new ToggleLiftPistonCommand());
		addSequential(new TimedOuttakeCommand(1.5));
    }
}
