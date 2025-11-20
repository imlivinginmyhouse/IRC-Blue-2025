package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FalconArm;

public class GotoPos extends Command{
    private final FalconArm arm;
    private final double position;
    public GotoPos(FalconArm arm, double position) {
        this.arm = arm;
        this.position = position;
        addRequirements(arm);
    }

    public void initialize() {
        arm.setGoalPosition(position);
    }

    public void end(boolean i) {
        arm.setGoalPosition(0);
    }
}
