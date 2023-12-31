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
  public static final int RIGHT_JOYSTICK_CHANNEL = 0;
  public static final int LEFT_JOYSTICK_CHANNEL = 1;


  // DRIVE CONSTANTS
  public static final int RIGHT_DRIVE_MOTOR1 = 2;
  public static final int RIGHT_DRIVE_MOTOR2 = 3;

  public static final int LEFT_DRIVE_MOTOR1 = 5;
  public static final int LEFT_DRIVE_MOTOR2 = 4;


  // BUNNY MOTOR CONSTANTS
  public static final int BUNNY_MOTOR = 1;

  public static final int BUNNY_MOTOR_STOP_SPEED = 0;
  public static final double BUNNY_MOTOR_START_SPEED = 0.4;

  // SHOOTER CONSTANTS
  public final static int SHOOTER_RIGHT_MOTOR = 12;               

  public static final int SHOOTER_STOP_SPEED = 0;
  public static final int SHOOTER_START_SPEED = 1;

  public static final double SHOOTER_STOP_TIME = 0.1;


  // INDEXER CONSTANTS
  public final static int INDEX_MOTOR = 8;

  public static final int INDEX_STOP_SPEED = 0;
  public static final double INDEX_START_SPEED = 0.7;

  // LEFT JOYSTICK BUTTON CONSTANTS
  public static final int BUNNY_IN_BUTTON =4;

  // RIGHT JOYSTICK BUTTON CONSTANTS
  public final static int INDEX_BUTTON = 1;
  public final static int BUNNY_OUT_BUTTON = 3;


}
