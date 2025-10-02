package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static edu.wpi.first.units.Units.Micro;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private final PWMSparkMax leftMotor = new PWMSparkMax(0);
    private final PWMSparkMax rightMotor = new PWMSparkMax(1);
    private final DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

    public Drivetrain() {
        SmartDashboard.putBoolean("Forward", false);
        SmartDashboard.putBoolean("Backward", false);
        SmartDashboard.putBoolean("Turn Left", false);
        SmartDashboard.putBoolean("Turn Right", false);

        setDefaultCommand (
            new RunCommand(() -> {
                double forward = 0;
                double turn = 0;

                if (SmartDashboard.getBoolean("Forward", false)) {
                    forward = Constants.DRIVE_SPEED;
                }
                if (SmartDashboard.getBoolean("Backward", false)) {
                    forward = -Constants.DRIVE_SPEED;
                }
                if (SmartDashboard.getBoolean("Turn Right", false)) {
                    turn = Constants.TURN_SPEED;
                }
                if (SmartDashboard.getBoolean("Turn Left", false)) {
                    turn = -Constants.TURN_SPEED;
                }

                drive.arcadeDrive(forward, turn);
            }, this )
        );
        }

    public void driveForward(double forward, double turn) {
        drive.arcadeDrive(forward, turn);
    }
    
    public void stop() {
        drive.arcadeDrive(0, 0);
    }
}