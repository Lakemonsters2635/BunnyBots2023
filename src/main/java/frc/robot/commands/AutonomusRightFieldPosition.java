// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AutonomusRightFieldPosition extends CommandBase {
  private double initPosition;
  private double displacement;
  // TODO change the degree
  private int degree = 360/180;

  /** Creates a new AutonomusLeftFieldPosition. */
  DrivetrainSubsystem m_drivetrainSubsystem;
  public AutonomusRightFieldPosition(DrivetrainSubsystem drivetrainSubsystem) {
    m_drivetrainSubsystem = drivetrainSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initPosition = m_drivetrainSubsystem.getEncoderPosition();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrainSubsystem.drive(-0.25, 0.25);
    double currentPose = m_drivetrainSubsystem.getEncoderPosition();
    displacement = currentPose - initPosition;
    displacement = Math.abs(displacement)*((6*Math.PI)/10.71);
    System.out.println(displacement);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrainSubsystem.setDriveTrainToBreakMode();
    m_drivetrainSubsystem.drive(0, 0);
    System.out.println("AutonomusFieldposition: End");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(displacement >= (23.6 / degree) * Math.PI){
      return true;
    }
    return false;
  }
}
