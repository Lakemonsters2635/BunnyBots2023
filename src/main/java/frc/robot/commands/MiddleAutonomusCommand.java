// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class MiddleAutonomusCommand extends SequentialCommandGroup {
  /** Creates a new MiddleAutonomusCommand. */
  public MiddleAutonomusCommand(DrivetrainSubsystem dts, ShooterSubsystem shooterSubsystem, ElevatorSubsystem elevatorSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutonomousLeaveHomeCommand(dts),
      // TODO: new ElevatorCommand(elevatorSubsystem),
      new WaitCommand(1),
      new ShooterCommand(shooterSubsystem),
      new AutonomusTurnLeftCommand(dts),
      new ElevatorCommand(elevatorSubsystem),
      new WaitCommand(1),
      new ShooterCommand(shooterSubsystem),
      new AutonomusTurnRightCommand(dts),
      new AutonomusTurnRightCommand(dts),
      new ElevatorCommand(elevatorSubsystem),
      new WaitCommand(1),
      new ShooterCommand(shooterSubsystem)
    );
  }
}
