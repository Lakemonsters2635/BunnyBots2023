// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousCommand extends SequentialCommandGroup {
  /** Creates a new AutonomousCommand. */
  private static double AUTO_SPEED = 0.2;
  public AutonomousCommand(DrivetrainSubsystem dts) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new InstantCommand(()->dts.drive(-1* AUTO_SPEED, -1* AUTO_SPEED)),
      new WaitCommand(1.5),
      new InstantCommand(()->dts.drive(AUTO_SPEED, -1 * AUTO_SPEED)),
      new WaitCommand(5.15),
      new InstantCommand(()->dts.drive(-1 *AUTO_SPEED,-1 * AUTO_SPEED)),
      new WaitCommand(1.5),
      new InstantCommand(()->dts.drive(0,0))
      );
  }
}
 