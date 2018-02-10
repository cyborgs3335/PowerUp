package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem implements LoggableSubsystem {
	//this subsystem at the moment employs a motor to lower the launcher over a spring but is subject to change
	private WPI_TalonSRX launcherMotorRight;
	private WPI_TalonSRX launcherMotorLeft;
	private Encoder launcherEncoder;
	double pulsesPerRevolution = 256;
	double encoderToShaftRatio = 3;
	double stage3Ratio = 50.0 / 34.0;
	
	public Launcher() {
		launcherMotorRight = new WPI_TalonSRX(RobotMap.LAUNCHER_RIGHT_MOTOR);
		launcherMotorLeft = new WPI_TalonSRX(RobotMap.LAUNCHER_LEFT_MOTOR);
		launcherEncoder = new Encoder(RobotMap.LAUNCHER_ENCODER_A, RobotMap.LAUNCHER_ENCODER_B,
        RobotMap.LAUNCHER_ENCODER_REVERSE, EncodingType.k4X);
		launcherMotorRight.setNeutralMode(NeutralMode.Brake);
		launcherMotorLeft.setNeutralMode(NeutralMode.Brake);
		// Motors turn in opposite direction.  Must flip polarity of one.
		launcherMotorLeft.setInverted(true);
	}

	
    public void initDefaultCommand() {
    }

    public void turn() {
    	launcherMotorRight.set(1);
    	launcherMotorLeft.set(1);
    }

    public void stop() {
    	launcherMotorRight.set(0);
    	launcherMotorLeft.set(0);
    }



	@Override
	public void log() {
		// TODO Auto-generated method stub
		
	}
}
	
