package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {
    private final PWMSparkMax leftMotor = new PWMSparkMax(0);
    private final PWMSparkMax rightMotor = newPWMSparkMax(1);
    private final DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

    public Drivetrain() {}

    public void arcadeDrive(double forward, double turn) {
        drive.arcadeDrive(forward, turn);
    }
    
}