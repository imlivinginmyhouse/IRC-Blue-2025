package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.FalconArm;

public class BasicAuto extends SequentialCommandGroup{

    public BasicAuto(Drivetrain drivetrain, FalconArm falconArm) {
        addCommands(
            new DriveAuto(drivetrain, 0.5, 0.5).withTimeout(1.5)
        );
    }
}
