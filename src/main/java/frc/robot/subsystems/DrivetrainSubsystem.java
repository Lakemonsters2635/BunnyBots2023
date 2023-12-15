// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */
  public CANSparkMax m_leftMotor1;
  public CANSparkMax m_leftMotor2;
  public CANSparkMax m_rightMotor1;
  public CANSparkMax m_rightMotor2;
  public DifferentialDrive m_drive;
  public MotorControllerGroup right;
  public MotorControllerGroup left;

  public DrivetrainSubsystem() {
    m_leftMotor1 = new CANSparkMax(Constants.LEFT_DRIVE_MOTOR1, MotorType.kBrushless);
    m_leftMotor2 = new CANSparkMax(Constants.LEFT_DRIVE_MOTOR2, MotorType.kBrushless);
    m_rightMotor1 = new CANSparkMax(Constants.RIGHT_DRIVE_MOTOR1, MotorType.kBrushless);
    m_rightMotor2 = new CANSparkMax(Constants.RIGHT_DRIVE_MOTOR2, MotorType.kBrushless);


    m_leftMotor1.setInverted(true);
    m_leftMotor2.setInverted(true);
    right = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);
    left = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
    m_drive = new DifferentialDrive(left, right);
    m_drive.setDeadband(0.05);

  }

  public void drive (double rightJoystick, double leftJoystick) {
    // m_leftMotor1.set(leftJoystick);
    // m_leftMotor2.set(leftJoystick);
    // m_rightMotor1.set(rightJoystick);
    // m_rightMotor2.set(rightJoystick);
    m_drive.tankDrive(leftJoystick, rightJoystick);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per schedule r run
  }
}
