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
  public CANSparkMax m_leftShooterMotor;
  
  public ShooterSubsystem() {
    m_leftShooterMotor = new CANSparkMax(Constants.SHOOTER_LEFT_MOTOR, MotorType.kBrushless);
    m_rightShooterMotor = new CANSparkMax(Constants.SHOOTER_RIGHT_MOTOR, MotorType.kBrushless);

    m_leftShooterMotor.setInverted(true);

  }
  
  public void shoot(double leftShooterMotorValue, double rightShooterMotorValue){
    m_leftShooterMotor.set(leftShooterMotorValue);
    m_rightShooterMotor.set(rightShooterMotorValue);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
