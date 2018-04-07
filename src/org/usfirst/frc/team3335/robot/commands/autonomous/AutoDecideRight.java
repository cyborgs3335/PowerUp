package org.usfirst.frc.team3335.robot.commands.autonomous;


import org.usfirst.frc.team3335.robot.commands.ArmMove;
import org.usfirst.frc.team3335.robot.commands.ArmMoveBack;
import org.usfirst.frc.team3335.robot.commands.ArmMoveToPosition;
import org.usfirst.frc.team3335.robot.commands.Hand;
import org.usfirst.frc.team3335.robot.commands.LaunchCubeSmall;
import org.usfirst.frc.team3335.robot.commands.PlaceCubeInSwitch;
import org.usfirst.frc.team3335.robot.commands.PneumaticLaunchCube;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallLaunchCube;
import org.usfirst.frc.team3335.robot.commands.PneumaticSmallestLaunchCube;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDecideRight extends CommandGroup {
	
	public AutoDecideRight() throws InterruptedException {
		double distance;
		double armSpeed = 0.3;
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData == null  || gameData.isEmpty() || gameData.length() < 3) {
			return;
		}
		char ourSwitch = gameData.charAt(0);
		char Scale = gameData.charAt(1);
		//char theirSwitch = gameData.charAt(2);
		/*
		if(Scale == 'L') {
			addSequential(new AutoDriveStraight(288,.6));
		}
		*/
		if (ourSwitch == 'R') {
			//robot goes to switch and places cube
			//if strait on
			//addSequential(new AutoDriveStraightPlaceCube());
			//if not straight on 
			addSequential(new ArmMove(-armSpeed), 2);
			addSequential(new ArmMoveBack(150, armSpeed), 2);
			addSequential(new Hand(true));
			addSequential(new AutoDriveStraight(110, 0.5, true, 30, 0.25));
			addSequential(new AutoDriveTurnToScale(-73, 0.5));
			distance = AutoDriveToSwitch.GetDistance();
			addSequential(new AutoDriveStraight(distance,.5, true, 30, .25));
			addSequential(new AutoDriveStraight(15,.3));
			//addSequential(new LaunchCubeSmall());
			addSequential(new PlaceCubeInSwitch(4));
		} 

		/*
		if(Scale == 'R') { 
			//robot drives to and turns to scale
			addSequential(new AutoDriveStraight(300,.3));
			addSequential(new AutoDriveToScaleTurn(90));
			addSequential(new AutoBackToWall());
			addSequential(new PneumaticLaunchCube());
		}
		
		*/
		else {
			//robot drives across autoline
			addSequential(new ArmMove(-armSpeed), 2);
			addSequential(new ArmMoveBack(200, armSpeed), 2);
			addSequential(new AutoDriveStraight(110, 0.5));
		}
	}
}
