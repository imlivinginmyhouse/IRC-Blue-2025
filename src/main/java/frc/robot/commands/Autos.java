package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class Autos extends Command {
    /** Example static factory for an autonomous command. */
  public static Command exampleAuto(Drivetrain drivetrain) {
    return new SequentialCommandGroup(
        drivetrain.new Drive(1, 1).withTimeout(2),
        drivetrain.new Drive(-1, -1).withTimeout(0.35)
    );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}