// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
  public CANSparkMax elevator1;
  public CANSparkMax elevator2;

  public ElevatorSubsystem() {
    elevator1 = new CANSparkMax(Constants.ELEVATOR1, MotorType.kBrushless);
    elevator2 = new CANSparkMax(Constants.ELEVATOR2, MotorType.kBrushless);
  }
  
  public void startElevator(){
    elevator1.set(Constants.ELEVATOR_START_SPEED);
    elevator2.set(Constants.ELEVATOR_START_SPEED);
  }

  public void stopElevator() {
    elevator1.set(Constants.ELEVATOR_STOP_SPEED);
    elevator2.set(Constants.ELEVATOR_STOP_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
