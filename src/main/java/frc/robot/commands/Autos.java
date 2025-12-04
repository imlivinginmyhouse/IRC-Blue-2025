package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.FalconArm;

public class Autos extends Command {
  public static Command exampleAuto(Drivetrain drivetrain, FalconArm falconArm) {
    return new SequentialCommandGroup(
        drivetrain.new Drive(1, 1).withTimeout(2),
        drivetrain.new Drive(-1, -1).withTimeout(0.35),
        new GotoPos(falconArm, 3.00).withTimeout(0.5),
        new GotoPos(falconArm, 0).withTimeout(0.3)
    );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}