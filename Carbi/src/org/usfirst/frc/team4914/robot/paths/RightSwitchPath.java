package com.team254.frc2017.paths;

import java.util.ArrayList;

import com.team254.frc2017.paths.PathBuilder.Waypoint;
import com.team254.lib.util.control.Path;
import com.team254.lib.util.math.RigidTransform2d;
import com.team254.lib.util.math.Rotation2d;
import com.team254.lib.util.math.Translation2d;

public class UntitledPath implements PathContainer {
    
    @Override
    public Path buildPath() {
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(15,162,0,0)); //start
        sWaypoints.add(new Waypoint(72,162,20,40)); //switch-wall midpoint
        sWaypoints.add(new Waypoint(72,108,20,20)); //54 up/down
        sWaypoints.add(new Waypoint(129,108,0,0));

        return PathBuilder.buildPathFromWaypoints(sWaypoints);
    }
    
    @Override
    public RigidTransform2d getStartPose() {
        return new RigidTransform2d(new Translation2d(15, 162), Rotation2d.fromDegrees(180.0)); 
    }

    @Override
    public boolean isReversed() {
        return false; 
    }
	// WAYPOINT_DATA: [{"position":{"x":15,"y":162},"speed":0,"radius":0,"comment":"start"},{"position":{"x":72,"y":162},"speed":40,"radius":20,"comment":"switch-wall midpoint"},{"position":{"x":72,"y":108},"speed":20,"radius":20,"comment":"54 up/down"},{"position":{"x":129,"y":108},"speed":0,"radius":0,"comment":""}]
	// IS_REVERSED: false
	// FILE_NAME: UntitledPath
}