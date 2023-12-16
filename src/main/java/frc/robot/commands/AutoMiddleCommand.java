// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IndexSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoMiddleCommand extends SequentialCommandGroup {
  /** Creates a new AutoMiddleCommand. */
  public AutoMiddleCommand(DrivetrainSubsystem drivetrainSubsystem, IndexSubsystem m_iS) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new LeaveHomeCommand(drivetrainSubsystem),
      new ParallelCommandGroup( new WaitCommand(1),
      new SequentialCommandGroup( new InstantCommand(()->drivetrainSubsystem.drive(-0.46, 0.46)),
                                  new WaitCommand(1),
                                  new InstantCommand(()->drivetrainSubsystem.drive(0, 0))) 
    ),
      new IndexCommand(m_iS),
      new IndexCommand(m_iS),
      new ParallelCommandGroup( new WaitCommand(1),
                                new SequentialCommandGroup( new InstantCommand(()->drivetrainSubsystem.drive(0.46, -0.46)),
                                                            new WaitCommand(0.4),
                                                            new InstantCommand(()->drivetrainSubsystem.drive(0, 0))) 
                              ),
      new IndexCommand(m_iS),
      new IndexCommand(m_iS),
      new ParallelCommandGroup( new WaitCommand(1),
                                new SequentialCommandGroup( new InstantCommand(()->drivetrainSubsystem.drive(0.46, -0.46)),
                                                            new WaitCommand(0.4),
                                                            new InstantCommand(()->drivetrainSubsystem.drive(0, 0))) 
                              ),
      new IndexCommand(m_iS),
      new IndexCommand(m_iS),
      new ParallelCommandGroup( new WaitCommand(1),
                                new SequentialCommandGroup( new InstantCommand(()->drivetrainSubsystem.drive(0.46, -0.46)),
                                                            new WaitCommand(0.4),
                                                            new InstantCommand(()->drivetrainSubsystem.drive(0, 0))) 
                              ),
      new IndexCommand(m_iS),
      new IndexCommand(m_iS),
      new ParallelCommandGroup( new WaitCommand(1),
                                new SequentialCommandGroup( new InstantCommand(()->drivetrainSubsystem.drive(0.46, -0.46)),
                                                            new WaitCommand(0.4),
                                                            new InstantCommand(()->drivetrainSubsystem.drive(0, 0))) 
                              ),
      new IndexCommand(m_iS),
      new IndexCommand(m_iS),
      new ParallelCommandGroup( new WaitCommand(1),
      new SequentialCommandGroup( new InstantCommand(()->drivetrainSubsystem.drive(-0.46, 0.46)),
                                  new WaitCommand(0.8),
                                  new InstantCommand(()->drivetrainSubsystem.drive(0, 0))) 
    ),
      new InstantCommand(()->drivetrainSubsystem.drive(-0.46,0.46)),
      new WaitCommand(3.34),
      new InstantCommand(()->drivetrainSubsystem.drive(0,0))

    );
  }
}
