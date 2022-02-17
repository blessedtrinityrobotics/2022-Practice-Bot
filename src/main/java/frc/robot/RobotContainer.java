// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.Constants.ShuffleboardConstants;
import frc.robot.commands.ArcadeDrive;
<<<<<<< HEAD
import frc.robot.commands.DriveStraightForward;
import frc.robot.commands.TankDrive;
=======
import frc.robot.commands.SpinShooterRaw;
>>>>>>> 677cc5d8471164264a540dc73d6c23c675f112b7
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import static frc.robot.Constants.OIConstants.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Shooter m_shooter = new Shooter();

  private final Joystick m_joystick1 = new Joystick(kLeftJoystickPort);
  private final Joystick m_joystick2 = new Joystick(kRightJoystickPort);

  SendableChooser<Command> m_driveStyleChooser = new SendableChooser<>();
  private final ArcadeDrive m_arcade = new ArcadeDrive(
      () -> m_joystick1.getY(),
      () -> m_joystick1.getX(),
      m_drivetrain);

  private final TankDrive m_tank = new TankDrive(
      () -> m_joystick1.getY(),
      () -> m_joystick2.getY(),
      m_drivetrain);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_driveStyleChooser.setDefaultOption("Arcade Drive", m_arcade);
    m_driveStyleChooser.addOption("Tank Drive", m_tank);

    Shuffleboard.getTab(ShuffleboardConstants.kDriveTab)
      .add("Drive Style", m_driveStyleChooser)
      .withSize(2, 1);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
<<<<<<< HEAD
  }

  public void teleopInit() {
    m_drivetrain.setDefaultCommand(m_driveStyleChooser.getSelected());
=======
    // m_drivetrain.setDefaultCommand(new ArcadeDrive(
    //   () -> m_joystick.getY(), 
    //   () -> m_joystick.getX(),
    //   m_drivetrain)
    // );

    m_shooter.setDefaultCommand(new SpinShooterRaw(() -> m_joystick.getY(), m_shooter));
>>>>>>> 677cc5d8471164264a540dc73d6c23c675f112b7
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * 
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new DriveStraightForward(-1000, m_drivetrain);
  }
}
