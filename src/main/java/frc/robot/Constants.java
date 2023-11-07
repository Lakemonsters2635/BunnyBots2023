// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  //MOTOR CHANNELS
  public static final int RIGHT_MOTOR1 = 8;
  public static final int RIGHT_MOTOR2 = 7;

  public static final int LEFT_MOTOR1 = 4;
  public static final int LEFT_MOTOR2 = 3;


  //ELEVATOR MOTOR CHANNELS
  // TODO: change these constants
  public static final int ELEVATOR1 = 5;
  public static final int ELEVATOR2 = 6;

  public static final int ELEVATOR_BUTTON = 4;

  public static final int ELEVATOR_STOP_TIME = 5;

  public static final int ELEVATOR_STOP_SPEED = 0;
  public static final int ELEVATOR_START_SPEED = 1;


  //Shooter motors
  public final static int SHOOTER_RIGHT_MOTOR = 5;
  public final static int SHOOTER_LEFT_MOTOR = 9;

  //Intake motor channel
  //TODO check that intake motor channel is correct
  public final static int INTAKE_MOTOR_CHANNEL = 6;

  // Shooter button
  public final static int SHOOTER_BUTTON = 1; //Right joystick button

  // Intake button
  //TODO check that intake button is correct
  public final static int INTAKE_BUTTON = 1;

  //Joysticks
  public static final int RIGHT_JOYSTICK_CHANNEL = 1;
  public static final int LEFT_JOYSTICK_CHANNEL = 0;
  //TODO: Change shooter motor types, if necessary
}
