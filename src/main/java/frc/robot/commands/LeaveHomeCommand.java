// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class LeaveHomeCommand extends CommandBase {
  /** Creates a new LeaveHomeCommand. */
  DrivetrainSubsystem m_drivetrainSubsystem;
  double displacement;
  Timer timer;
  int executeCount;
  

  public LeaveHomeCommand(DrivetrainSubsystem drivetrainSubsystem) {
    m_drivetrainSubsystem = drivetrainSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    timer = new Timer();
    executeCount=0;
    addRequirements(m_drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("LeaveHomeComand.initialize(): working");
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    executeCount++;
    m_drivetrainSubsystem.runDrivetrain();
    displacement = m_drivetrainSubsystem.getEncoderPos();
    displacement = Math.abs(displacement)*((6*Math.PI)/10.71);
    System.out.println("Time:"+timer.get()+"\tCount"+executeCount);
    if (executeCount==50) {
      executeCount=0;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    timer.reset();
    m_drivetrainSubsystem.stopDrivetrain();
    System.out.println("LeaveHomeComand.end(): working");
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (displacement>=300) {
      return true;
    }
    return false;
  }
}
