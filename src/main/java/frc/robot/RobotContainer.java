// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.ElevatorCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Subsystems
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  public final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public final IntakeCommand m_intakeCommand = new IntakeCommand(m_intakeSubsystem);
  public final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  public final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();

  public final ElevatorCommand m_elevatorCommand = new ElevatorCommand(m_elevatorSubsystem);

  //Commands
  private final ShooterCommand m_shooterCommand = new ShooterCommand(m_shooterSubsystem);

  //Joystick
  public final Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_CHANNEL);
  public final Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_CHANNEL);
  ////JoystickButtons
  //Joystick joystick = new Joystick(Constants.JOYSTICK_BUTTON);

  

  // Replace with CommandPS4Controller or CommandJoystick if needed
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    Trigger shooterButton = new JoystickButton(rightJoystick, Constants.SHOOTER_BUTTON);

    shooterButton.onTrue(m_shooterCommand);
    Trigger elevatorButton = new JoystickButton(leftJoystick, Constants.ELEVATOR_BUTTON);
    elevatorButton.onTrue(m_elevatorCommand);
    
    Trigger pButton = new JoystickButton(leftJoystick, Constants.INTAKE_BUTTON);

    pButton.whileTrue(m_intakeCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return 
   */
  public void getAutonomousCommand() {
    // An example command will be run in autonomous
  }
}
