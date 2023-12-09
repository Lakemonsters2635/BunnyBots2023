// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BunnyStealerSubsystem extends SubsystemBase {
  public CANSparkMax m_bunnyMotor;

  public BunnyStealerSubsystem() {
    m_bunnyMotor = new CANSparkMax(Constants.BUNNY_MOTOR, MotorType.kBrushless);
  }
  
  public void runBunnyStealer(){
    m_bunnyMotor.set(Constants.ELEVATOR_START_SPEED);
  }

  public void stopBunnyStealer() {
    m_bunnyMotor.set(Constants.ELEVATOR_STOP_SPEED);
  }

  public void runOutBunnyStealer(){
    m_bunnyMotor.set(Constants.ELEVATOR_START_SPEED * -1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
