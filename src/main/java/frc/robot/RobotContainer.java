// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Autos;
import frc.robot.commands.Drive;
import frc.robot.commands.LiftArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final Arm arm = new Arm();
  private final CommandXboxController controller = new CommandXboxController(0);
  private final Drive drive = new Drive(drivetrain, controller);
  private Trigger lift_arm_button_up = controller.a();
  private Trigger lift_arm_button_down = controller.b();

  public RobotContainer() {
    configureBindings();

    drivetrain.setDefaultCommand(drive);
  }

  public void configureBindings() {
    lift_arm_button_up.whileTrue(new LiftArm(arm, 0.5));
    lift_arm_button_down.whileTrue(new LiftArm(arm, -0.5));
    //comment
  }

  public Command getAutonomousCommand() {
    return Autos.exampleAuto(drivetrain);
  }
}
