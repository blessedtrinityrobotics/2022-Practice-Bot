// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int kFrontLeftMotorPort = 9;
        public static final int kBackLeftMotorPort = 1;
        public static final int kFrontRightMotorPort = 8;
        public static final int kBackRightMotorPort = 0;
        public static final int[] kRightEncoder = {1, 0};
        public static final int[] kLeftEncoder = {9, 8};
    }

    public static final class OIConstants {
        public static final int kLeftJoystickPort = 0;
        public static final int kRightJoystickPort = 1;
    }

    public static final class DrivetrainConstants {
        public static final double ksVolts = 0.74419;
        public static final double kvVoltSecondsPerFoot = 0.8949;
        public static final double kaVoltSecondsSquaredPerFoot = 0.034919;

        public static final double kPDriveVel = 0.72631;

        public static final double kTrackwidthFeet = 2.2683;
        public static final DifferentialDriveKinematics kDriveKinematics =
            new DifferentialDriveKinematics(kTrackwidthFeet);

        public static final double kMaxSpeedFeetPerSecond = 14;
        public static final double kMaxAccelerationFeetPerSecondSquared = 8;
        // TODO: Setup ramsete controller, remember we use feet not meters
    }

    public static final class ShuffleboardConstants {
        public static final String kDriveTab = "Driving";
    }
}
