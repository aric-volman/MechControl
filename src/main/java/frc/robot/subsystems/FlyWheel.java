// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {

  private final WPI_TalonSRX _flywheelTalon;

  /** Creates a new FlyWheel. */
  public FlyWheel() {
    _flywheelTalon = new WPI_TalonSRX(Constants.FlyWheelPortNumbers.FlyWheelPort);

    _flywheelTalon.configFactoryDefault();

    _flywheelTalon.setInverted(false);

    _flywheelTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void resetEncoders() {
    _flywheelTalon.setSelectedSensorPosition(0, 0, 10);
  }

  public double getEncoderPosition() {
    return _flywheelTalon.getSelectedSensorPosition(0);
  }

  public double getEncoderVelocityTicksPerSecond() {
    // Originally returned ticks per 100ms, multiply by 10 to correct it.
    return _flywheelTalon.getSensorCollection().getPulseWidthVelocity()*10.0;
  }
  public double getEncoderVelocityRotationsPerSecond() {
    return (_flywheelTalon.getSensorCollection().getPulseWidthVelocity()/4096.0);
  }
  public double getEncoderVelocityDegreesPerSecond() {
    return (_flywheelTalon.getSensorCollection().getPulseWidthVelocity()*10.0*360.0)/ 4096.0; // "Cross multiply"
  }

}
