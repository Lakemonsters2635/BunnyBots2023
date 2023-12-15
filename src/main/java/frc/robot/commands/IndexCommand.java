// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexSubsystem;

public class IndexCommand extends CommandBase {
  private IndexSubsystem m_indexSubsystem;
  private double revolution;
  private double setPoint;

  /** Creates a new IndexCommand. */
  public IndexCommand(IndexSubsystem indexSubsystem) {
    m_indexSubsystem = indexSubsystem;

    addRequirements(m_indexSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //System.out.println("Index.initialize()");
    m_indexSubsystem.runIndex();
    System.out.println("IndexCommand.initialize: working");
    revolution= m_indexSubsystem.getIndexPos()%100;
    if(revolution<33){
      setPoint = 33;
    }
    else if(revolution<66){
      setPoint = 66;
    }
    else if(revolution<100){
      setPoint = 100;
    }
    setPoint+= m_indexSubsystem.getIndexPos()- m_indexSubsystem.getIndexPos()%100;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //System.out.println("IndexCommand: Working");
    revolution= m_indexSubsystem.getIndexPos();
    System.out.println("Encoder Counts Modded: "+ revolution);
    //System.out.println("Encoder Counts"+ m_indexSubsystem.getIndexPos());

    //m_indexSubsystem.runIndex();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_indexSubsystem.stopIndex();
    System.out.println("IndexCommand.end: Running");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if(revolution>setPoint){
      System.out.println("Revolution:"+ revolution);
      System.out.println("SetPoint:" + setPoint);
      return true;
    }
    else {
      return false;
    }
  }
}
