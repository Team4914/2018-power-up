package org.usfirst.frc.team4914.robot.commands;

import org.usfirst.frc.team4914.robot.Robot;
import org.usfirst.frc.team4914.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSwitchCommand extends CommandGroup {

    public AutoSwitchCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	requires(Robot.m_drivetrain);
    	requires(Robot.m_intake);
    	// requires(Robot.m_lift);
    	
    	if (RobotConstants.ortnSwitch == 'L') { // drive to left switch
    		// run left switch motion profile
    	} else { // drive to right switch
    		// run right switch motion profile
    	}
    	
    	// sequential first stage lift
    	// sequential spit out
    	// sequential first stage spit out cube
    }
}
