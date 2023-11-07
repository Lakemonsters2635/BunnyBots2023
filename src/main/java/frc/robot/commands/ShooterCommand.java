// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {
  /** Creates a new ShooterCommand. */
  private ShooterSubsystem m_shooterSubsystem;
  private Timer timer;

  public ShooterCommand(ShooterSubsystem shooterSubsystem) {
    m_shooterSubsystem = shooterSubsystem;
    timer = new Timer();
    
    addRequirements(m_shooterSubsystem);
  }

  // Called when the command is initially scheduled.

  @Override
  public void initialize() {
    //timer reseted and started 
    timer.reset();
    timer.start();

    // Work shooter
    m_shooterSubsystem.runShooter();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooterSubsystem.stopShooter();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() >= Constants.SHOOTER_STOP_TIME){
      return true;
    }
    else {
      return false;
    }
  }
}
