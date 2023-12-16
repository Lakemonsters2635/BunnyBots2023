// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexSubsystem extends SubsystemBase {
  //Creates a new IndexSubsystem. 
  public CANSparkMax m_indexMotor;
  
  public IndexSubsystem() {
    m_indexMotor = new CANSparkMax(Constants.INDEX_MOTOR, MotorType.kBrushless);
    m_indexMotor.setInverted(true);
    m_indexMotor.setIdleMode(IdleMode.kBrake);
    resetIndexPos();
  }

  public void runIndex () {
    m_indexMotor.set(Constants.INDEX_START_SPEED);
  }

  public double getIndexPos(){
    return m_indexMotor.getEncoder().getPosition();
  }

  public void resetIndexPos(){
    m_indexMotor.getEncoder().setPosition(0);
  }

  public void stopIndex() {
    m_indexMotor.set(Constants.INDEX_STOP_SPEED);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
