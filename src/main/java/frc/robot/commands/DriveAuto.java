package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriveAuto extends Command{
    private final Drivetrain drivetrain;
    private final double lSpeed, rSpeed;

    public DriveAuto(Drivetrain drivetrain, double lSpeed, double rSpeed){
        this.drivetrain = drivetrain;
        this.lSpeed = lSpeed;
        this.rSpeed = rSpeed;
    }

    @Override
    public void initialize() {
        drivetrain.drive(lSpeed, rSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
