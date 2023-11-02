// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. 
  public CANSparkMax m_intakeMotor
  */
  public IntakeSubsystem() {
    /*
    m_intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_CHANNEL, MotorType.kBrushless);

    //Might need to invert motor
    
    */
  }

  /*public void intake (double rightJoystick) {
    m_intakeMotor.set(rightJoystick);
    //System.out.println("Intake method working")
  }
  */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
