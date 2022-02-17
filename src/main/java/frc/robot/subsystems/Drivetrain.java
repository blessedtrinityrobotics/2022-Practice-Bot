// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

<<<<<<< HEAD
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.*;
import static frc.robot.Constants.ShuffleboardConstants.*;

import java.util.Map;
=======
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.*;
import static frc.robot.Constants.ShuffleboardConstants.*;
>>>>>>> 677cc5d8471164264a540dc73d6c23c675f112b7

public class Drivetrain extends SubsystemBase {
  NetworkTableEntry speedMult = 
    Shuffleboard.getTab(kDriveTab)
      .addPersistent("Speed Multiplier", 1)
      .withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", 0, "max", 1))
      .withSize(2, 1)
      .getEntry();

  MotorControllerGroup m_left = new MotorControllerGroup(
    new VictorSP(kFrontLeftMotorPort), 
    new VictorSP(kBackLeftMotorPort));

  MotorControllerGroup m_right = new MotorControllerGroup(
    new VictorSP(kFrontRightMotorPort),
    new VictorSP(kBackRightMotorPort)
  );

<<<<<<< HEAD
  Encoder m_leftEncoder = new Encoder(kLeftEncoder[0], kLeftEncoder[1]);
  Encoder m_rightEncoder = new Encoder(kRightEncoder[0], kRightEncoder[1]);
=======
  ADIS16470_IMU gyro = new ADIS16470_IMU();
>>>>>>> 677cc5d8471164264a540dc73d6c23c675f112b7

  DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
  
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    m_right.setInverted(true);

<<<<<<< HEAD
    Shuffleboard.getTab(kDriveTab).add("Left Encoder", m_leftEncoder);
    Shuffleboard.getTab(kDriveTab).add("Left Motor", m_left);
    Shuffleboard.getTab(kDriveTab).add("Right Encoder", m_rightEncoder);
    Shuffleboard.getTab(kDriveTab).add("Right Motor", m_right);

 }
=======
    Shuffleboard.getTab(kDriveTab).add("Gyro", gyro);
  }
>>>>>>> 677cc5d8471164264a540dc73d6c23c675f112b7

  @Override
  public void periodic() {

  }

  public void arcadeDrive(double speed, double direction) {
    Double mult = speedMult.getDouble(1.0);
    m_drive.arcadeDrive(speed * mult, direction * mult);
  }

  public void tankDrive(double left, double right) {
    Double mult = speedMult.getDouble(1.0);
    m_drive.tankDrive(left * mult, right * mult);
  }

  public double getLeftDist() {
    return m_leftEncoder.getDistance();
  }

  public double getRightDist() {
    return m_rightEncoder.getDistance();
  }
}