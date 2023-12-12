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
  // JOYSTICKS
  public static final int RIGHT_JOYSTICK_CHANNEL = 1;
  public static final int LEFT_JOYSTICK_CHANNEL = 0;


  // DRIVE CONSTANTS
  // TODO: Change these
  public static final int RIGHT_DRIVE_MOTOR1 = 8;
  public static final int RIGHT_DRIVE_MOTOR2 = 7;

  public static final int LEFT_DRIVE_MOTOR1 = 4;
  public static final int LEFT_DRIVE_MOTOR2 = 3;


  //ELEVATOR CONSTANTS
  // TODO: Change these
  public static final int BUNNY_MOTOR = 5;

  public static final int ELEVATOR_STOP_SPEED = 0;
  public static final int ELEVATOR_START_SPEED = 1;
  
  public static final int ELEVATOR_STOP_TIME = 5;


  // SHOOTER CONSTANTS
  // TODO: Change these
  public final static int SHOOTER_RIGHT_MOTOR = 5;
  //public final static int SHOOTER_LEFT_MOTOR = 9;

  public static final int SHOOTER_STOP_SPEED = 0;
  public static final int SHOOTER_START_SPEED = 1;

  public static final int SHOOTER_STOP_TIME = 5;


  // INTAKE CONSTANTS
  // TODO: Change these
  public final static int INTAKE_MOTOR = 6;

  public static final int INTAKE_STOP_SPEED = 0;
  public static final int INTAKE_START_SPEED = 1;

  public static final int INTAKE_STOP_TIME = 5;

  // LEFT JOYSTICK BUTTON CONSTANTS
  public static final int BUNNY_IN_BUTTON = 4;
  public final static int INDEX_BUTTON = 1;
  public final static int BUNNY_OUT_BUTTON = 6;

  // RIGHT JOYSTICK BUTTON CONSTANTS
  public final static int SHOOTER_BUTTON = 1;


}
