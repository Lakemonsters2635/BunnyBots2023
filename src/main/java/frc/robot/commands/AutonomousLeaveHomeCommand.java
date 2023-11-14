// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;


public class AutonomousLeaveHomeCommand extends CommandBase {
  /** Creates a new AutonomousLeaveHomeCommand. */
  DrivetrainSubsystem m_drivetrainSubsystem;
  public AutonomousLeaveHomeCommand(DrivetrainSubsystem drivetrainSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrainSubsystem = drivetrainSubsystem;
    addRequirements(m_drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrainSubsystem.resetDisplacement();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrainSubsystem.drive(-0.2, -0.2);
    System.out.println("zDisplacement = " + m_drivetrainSubsystem.getZDisplacement());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrainSubsystem.drive(0, 0);
    System.out.println("ended!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_drivetrainSubsystem.getXDisplacement() >= 2) {
    System.out.println("returning finished");
    return true;
    } else {
    return false;
    }
  }
}
