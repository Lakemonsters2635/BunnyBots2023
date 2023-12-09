// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.BunnyStealerSubsystem;

public class BunnyStealerOutCommand extends CommandBase {
  private BunnyStealerSubsystem m_bunnyStealerSubsystem;
  private Timer timer;

  public BunnyStealerOutCommand(BunnyStealerSubsystem bunnyStealerSubsystem) {
    m_bunnyStealerSubsystem = bunnyStealerSubsystem;
    timer = new Timer();

    addRequirements(m_bunnyStealerSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    m_bunnyStealerSubsystem.runOutBunnyStealer();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_bunnyStealerSubsystem.stopBunnyStealer();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if(timer.get() >= Constants.ELEVATOR_STOP_TIME){
    //   return true;
    // } else {
    //   return false;
    // }
    return false;
  }
}
