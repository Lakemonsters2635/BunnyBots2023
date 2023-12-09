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
    //TODO: Need neo 550 controllor to feed the balls one by one, motors will have an encoder in them
    //      We need to use that encoder to advance the brushes a certain amount so that only one ball is released at a time.
    //      Or have the neo just go slow and feed the balls in slowly as the operator holds down a button
    //      Or brainstorm multiple ways to do it and what we think as a team is the best way to do it
    //m_rightShooterMotor.setInverted(true);

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
  }
}
