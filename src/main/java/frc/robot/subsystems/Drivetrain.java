package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private final VictorSP leftMotor;
    private final VictorSP rightMotor;

    public Drivetrain() {
        leftMotor = new VictorSP(0);
        rightMotor = new VictorSP(1);
        rightMotor.setInverted(true);
    }

    public void drive(double left, double right) {
        leftMotor.set(left);
        rightMotor.set(right);
    }
    
    public void stop() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }
}