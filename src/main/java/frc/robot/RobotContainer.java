// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.BunnyStealerInCommand;
import frc.robot.commands.BunnyStealerOutCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.BunnyStealerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
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
  public final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public final BunnyStealerSubsystem m_bunnyStealerSubsystem = new BunnyStealerSubsystem();

  // COMMANDS
  private final ShooterCommand m_shooterCommand = new ShooterCommand(m_shooterSubsystem);
  public final IntakeCommand m_intakeCommand = new IntakeCommand(m_intakeSubsystem);
  public final BunnyStealerInCommand m_bunnyStealerInCommand = new BunnyStealerInCommand(m_bunnyStealerSubsystem);
  public final BunnyStealerOutCommand m_bunnyStealerOutCommand = new BunnyStealerOutCommand(m_bunnyStealerSubsystem);



  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    // Creating Buttons
    Trigger shooterButton = new JoystickButton(rightJoystick, Constants.SHOOTER_BUTTON);
    Trigger bunniesInButton = new JoystickButton(leftJoystick, Constants.BUNNY_IN_BUTTON);
    Trigger bunniesOutButton = new JoystickButton(leftJoystick, Constants.BUNNY_OUT_BUTTON);
    Trigger intakeButton = new JoystickButton(leftJoystick, Constants.INTAKE_BUTTON);

    shooterButton.onTrue(m_shooterCommand);
    bunniesInButton.onTrue(m_bunnyStealerInCommand);
    bunniesOutButton.onTrue(m_bunnyStealerOutCommand);
    intakeButton.onTrue(m_intakeCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return 
   */
  public void getAutonomousCommand() {
    // An example command will be run in autonomous
  }
}
