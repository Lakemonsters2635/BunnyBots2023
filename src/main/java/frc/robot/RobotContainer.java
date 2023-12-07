// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.AutonomousCommand;
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

  public final AHRS navX = new AHRS(SPI.Port.kMXP);
  // JOYSTICKS
  public final Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_CHANNEL);
  public final Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_CHANNEL);

  // SUBSYSTEMS
  public final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem(navX);
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  public final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();

  private SendableChooser<CommandGroupBase> m_autoChooser;


  // COMMANDS
  private final ShooterCommand m_shooterCommand = new ShooterCommand(m_shooterSubsystem);
  public final IntakeCommand m_intakeCommand = new IntakeCommand(m_intakeSubsystem);
  public final ElevatorCommand m_elevatorCommand = new ElevatorCommand(m_elevatorSubsystem);
  
  public final AutonomousCommand m_autonomousCommand = new AutonomousCommand(m_drivetrainSubsystem, m_shooterSubsystem);


  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    // Creating Buttons
    Trigger shooterElevatorButton = new JoystickButton(rightJoystick, Constants.SHOOTER_BUTTON);
    Trigger elevatorButton = new JoystickButton(leftJoystick, Constants.ELEVATOR_BUTTON);
    Trigger intakeElevatorButton = new JoystickButton(leftJoystick, Constants.INTAKE_BUTTON);

    shooterElevatorButton.onTrue(new SequentialCommandGroup(m_shooterCommand.withTimeout(0.3), m_elevatorCommand.withTimeout(0.3)));
    elevatorButton.whileTrue(m_elevatorCommand);
    intakeElevatorButton.whileTrue(new ParallelCommandGroup(m_intakeCommand, m_elevatorCommand));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return 
   * @return 
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    m_autoChooser = new SendableChooser<>();
    m_autoChooser.addOption("Drive Straight", m_autonomousCommand);
    SmartDashboard.putData("AutoMode", m_autoChooser);

    //return m_autoChooser.getSelected();
    return m_autonomousCommand;
  }
}
