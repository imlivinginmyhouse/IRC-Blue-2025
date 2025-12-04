// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.AnalogArm;
import frc.robot.commands.Autos;
import frc.robot.commands.Drive;
import frc.robot.commands.GotoPos;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.FalconArm;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  //private final Arm arm = new Arm();
  private final FalconArm falconArm = new FalconArm();
  private final CommandXboxController controller = new CommandXboxController(0);
  private final Drive drive = new Drive(drivetrain, controller);
  private final AnalogArm analogArm = new AnalogArm(falconArm, controller);
  private Trigger lift_arm_button_up = controller.rightTrigger();

  public RobotContainer() {
    configureBindings();

    drivetrain.setDefaultCommand(drive);
    falconArm.setDefaultCommand(analogArm);
  }

  public void configureBindings() {
    //System.out.println(lift_arm_button_up);
    //lift_arm_button_up.whileTrue(new GotoPos(falconArm, 3.0));
  }

  public Command getAutonomousCommand() {
    return Autos.exampleAuto(drivetrain, falconArm);
  }
}
