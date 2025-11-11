package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

public class LiftArm extends Command {
    private double six_seven_direction;
    private final Arm arm;

    public LiftArm(Arm arm, double six_seven_direction) {
        this.arm = arm;
        this.six_seven_direction = six_seven_direction;
        addRequirements(arm);
    }

    public void initialize() {
        arm.lift(six_seven_direction);
    }

    public void end(boolean i){
        arm.lift(0);
    }
}