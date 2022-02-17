package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/**
 * Basic Arcade Driving command, very similar to {@link TankDrive}
 */
public class ArcadeDrive extends CommandBase {
    
    private final Drivetrain m_drivetrain;

    private final DoubleSupplier m_speed;
    private final  DoubleSupplier m_direction;

    /**
     * Creates a new Tank Drive Command.
     * @param speed Presumably the joystick to control left power
     * @param direction Presumably the joystick to control right power
     * @param drivetrain DriveTrain subsystem for manipulation
     */
    public ArcadeDrive(DoubleSupplier speed, DoubleSupplier direction, Drivetrain drivetrain) {
        m_drivetrain = drivetrain;
        m_speed = speed;
        m_direction = direction;

        addRequirements(m_drivetrain);
    }

    @Override
    public void initialize() {
        m_drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        m_drivetrain.arcadeDrive(m_speed.getAsDouble(), m_direction.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        //Reset arcade drive
        m_drivetrain.arcadeDrive(0, 0);
    }

}
