// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new shooterSubsystem. */
  public CANSparkMax m_rightShooterMotor;
  
  public ShooterSubsystem() {
    m_rightShooterMotor = new CANSparkMax(Constants.SHOOTER_RIGHT_MOTOR, MotorType.kBrushless);
    m_rightShooterMotor.setInverted(true);
  }
  
  public void runShooter(){
    m_rightShooterMotor.set(Constants.SHOOTER_START_SPEED);
  }

  public void stopShooter(){
    m_rightShooterMotor.set(Constants.SHOOTER_STOP_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    runShooter();
  }
}
