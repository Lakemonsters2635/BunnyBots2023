// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.AutonomousGroup;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
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
  public final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();

  // COMMANDS
  private final ShooterCommand m_shooterCommand = new ShooterCommand(m_shooterSubsystem);
  public final IntakeCommand m_intakeCommand = new IntakeCommand(m_intakeSubsystem);
  public final ElevatorCommand m_elevatorCommand = new ElevatorCommand(m_elevatorSubsystem);

  private final AutonomousGroup m_autonomousGroup = new AutonomousGroup(m_drivetrainSubsystem);
  private SendableChooser<CommandGroupBase> m_autoChooser;


  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    // Creating Buttons
    Trigger shooterButton = new JoystickButton(rightJoystick, Constants.SHOOTER_BUTTON);
    Trigger elevatorButton = new JoystickButton(leftJoystick, Constants.ELEVATOR_BUTTON);
    Trigger intakeButton = new JoystickButton(leftJoystick, Constants.INTAKE_BUTTON);

    shooterButton.onTrue(m_shooterCommand);
    elevatorButton.onTrue(m_elevatorCommand);
    intakeButton.whileTrue(m_intakeCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return 
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    m_autoChooser = new SendableChooser<>();
    m_autoChooser.addOption("Drive Straight", m_autonomousGroup);
    SmartDashboard.putData("AutoMode", m_autoChooser);
    
    // return m_autoChooser.getSelected();
    return m_autonomousGroup;
  }
}
