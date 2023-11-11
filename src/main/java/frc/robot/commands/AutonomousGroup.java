// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousGroup extends SequentialCommandGroup {
  /** Creates a new AutonomousGroup. */
  private Timer timer;
  public AutonomousGroup(DrivetrainSubsystem dts) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());

    addCommands(
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(5),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(2.5),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    

    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(5),

    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(1.25),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(2.5),

    new SequentialCommandGroup(new InstantCommand(()->dts.drive(0.1,-0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(1.25),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(2.5),

    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(2.5),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(2.5),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(1.25),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(0.1,-0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(1.25),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(0.1,-0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(1.25),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(1.25),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,-0.1))),
    new WaitCommand(2.5),
    new SequentialCommandGroup(new InstantCommand(()->dts.drive(-0.1,0.1))),
    new WaitCommand(1.67),

    new SequentialCommandGroup(new InstantCommand(()->dts.drive(0,0)))
    );
  }
}
