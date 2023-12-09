// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */
  public CANSparkMax m_leftMotor1;
  public CANSparkMax m_leftMotor2;
  public CANSparkMax m_rightMotor1;
  public CANSparkMax m_rightMotor2;

  public DrivetrainSubsystem() {
    m_leftMotor1 = new CANSparkMax(Constants.LEFT_DRIVE_MOTOR1, MotorType.kBrushless);
    m_leftMotor2 = new CANSparkMax(Constants.LEFT_DRIVE_MOTOR2, MotorType.kBrushless);
    m_rightMotor1 = new CANSparkMax(Constants.RIGHT_DRIVE_MOTOR1, MotorType.kBrushless);
    m_rightMotor2 = new CANSparkMax(Constants.RIGHT_DRIVE_MOTOR2, MotorType.kBrushless);
    
    m_leftMotor1.setInverted(true);
    m_leftMotor2.setInverted(true);
    setDriveTrainToCoastMode();

  }

  public void drive (double rightJoystick, double leftJoystick) {
    m_leftMotor1.set(leftJoystick * Constants.DEBUG_MAX_SPEED);
    m_leftMotor2.set(leftJoystick * Constants.DEBUG_MAX_SPEED);
    m_rightMotor1.set(rightJoystick * Constants.DEBUG_MAX_SPEED);
    m_rightMotor2.set(rightJoystick * Constants.DEBUG_MAX_SPEED);
  }

  public void setDriveTrainToBreakMode(){
    m_leftMotor1.setIdleMode(IdleMode.kBrake);
    m_leftMotor2.setIdleMode(IdleMode.kBrake);
    m_rightMotor1.setIdleMode(IdleMode.kBrake);
    m_rightMotor2.setIdleMode(IdleMode.kBrake);
  }

  public void setDriveTrainToCoastMode(){
    m_leftMotor1.setIdleMode(IdleMode.kCoast);
    m_leftMotor2.setIdleMode(IdleMode.kCoast);
    m_rightMotor1.setIdleMode(IdleMode.kCoast);
    m_rightMotor2.setIdleMode(IdleMode.kCoast);
  }

  public double getEncoderPosition () {
    return m_leftMotor1.getEncoder().getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per schedule r run
  }
}
