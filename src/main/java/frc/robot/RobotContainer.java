// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.AutoLeftCommand;
import frc.robot.commands.BunnyStealerInCommand;
import frc.robot.commands.BunnyStealerOutCommand;
import frc.robot.commands.IndexCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.BunnyStealerSubsystem;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // JOYSTICKS
  public final Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_CHANNEL);
  public final Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_CHANNEL);

  // SUBSYSTEMS
  public final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  public final IndexSubsystem m_indexSubsystem = new IndexSubsystem();
  public final BunnyStealerSubsystem m_bunnyStealerSubsystem = new BunnyStealerSubsystem();

  // COMMANDS
  public final IndexCommand m_indexCommand = new IndexCommand(m_indexSubsystem);
  public final IndexCommand m_indexCommand2 = new IndexCommand(m_indexSubsystem);

  public final BunnyStealerInCommand m_bunnyStealerInCommand = new BunnyStealerInCommand(m_bunnyStealerSubsystem);
  public final BunnyStealerOutCommand m_bunnyStealerOutCommand = new BunnyStealerOutCommand(m_bunnyStealerSubsystem);

  // AUTONOMUS COMMANDS
  public final AutoLeftCommand m_autoLeftCommand = new AutoLeftCommand(m_drivetrainSubsystem, m_indexSubsystem);

  private SendableChooser<Command> m_autoChooser;

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    // Creating Buttons
    Trigger indexButton = new JoystickButton(rightJoystick,Constants.INDEX_BUTTON);
    Trigger bunniesInButton = new JoystickButton(leftJoystick, Constants.BUNNY_IN_BUTTON);
    Trigger bunniesOutButton = new JoystickButton(rightJoystick, Constants.BUNNY_OUT_BUTTON);

    indexButton.onTrue(new SequentialCommandGroup(m_indexCommand,
                                                  m_indexCommand2,
                                                  new WaitCommand(1)));
    bunniesInButton.whileTrue(m_bunnyStealerInCommand);
    bunniesOutButton.whileTrue(m_bunnyStealerOutCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return 
   */
  public SendableChooser<Command> getAutonomousCommand() {
    // An example command will be run in autonomous
    m_autoChooser = new SendableChooser<>();
    m_autoChooser.addOption("Left", m_autoLeftCommand);
    
    SmartDashboard.putData("AutoMode",m_autoChooser);
    return m_autoChooser;
  }
}
