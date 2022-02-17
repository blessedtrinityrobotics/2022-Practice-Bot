// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveStraightForward extends CommandBase {
  private final Drivetrain m_drivetrain;
  private double dist = 0;

  /** Creates a new DriveStraightForward. */
  public DriveStraightForward(double _dist, Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    dist = _dist;
    m_drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPower = 0;
    double rightPower = 0;
    if (m_drivetrain.getLeftDist() > dist) {
      leftPower = 0.5;
    }
    if (m_drivetrain.getRightDist() > dist) {
      rightPower = 0.5;
    }

    m_drivetrain.tankDrive(leftPower, rightPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
