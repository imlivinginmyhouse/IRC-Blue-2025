
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.FalconArm;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class AnalogArm extends Command{
    private final FalconArm arm;
    private final CommandXboxController controller;
    public AnalogArm(FalconArm arm, CommandXboxController controller) {
        this.arm = arm;
        this.controller = controller;
        addRequirements(arm);
    }

    public void execute() {
        arm.setGoalPosition(controller.getRightTriggerAxis() * 30);
        //System.out.println(controller.getRightTriggerAxis());
    }

    public void end(boolean i) {
        arm.setGoalPosition(0);
    }
}