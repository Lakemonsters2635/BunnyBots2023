// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  //Creates a new IntakeSubsystem. 
  public CANSparkMax m_intakeMotor;
  
  public IntakeSubsystem() {
    
    m_intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_CHANNEL, MotorType.kBrushless);

    //Might need to invert motor
    
  }

  public void runIntake () {
    m_intakeMotor.set(1);
  }

  public void stopIntake() {
    m_intakeMotor.set(0);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
