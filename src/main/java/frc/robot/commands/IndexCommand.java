// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexSubsystem;

public class IndexCommand extends CommandBase {
  private IndexSubsystem m_indexSubsystem;

  /** Creates a new IndexCommand. */
  public IndexCommand(IndexSubsystem indexSubsystem) {
    m_indexSubsystem = indexSubsystem;

    addRequirements(m_indexSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_indexSubsystem.resetIndexPos();
    m_indexSubsystem.runIndex();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("IndexCommand: Working");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_indexSubsystem.stopIndex();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_indexSubsystem.getIndexPos() >= (double)1/3){
      return true;
    }
    else {
      return false;
    }
  }
}
