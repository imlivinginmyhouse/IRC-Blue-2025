package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private final VictorSP leftMotor;
    private final VictorSP rightMotor;
    private final Timer timer = new Timer();

    public Drivetrain() {
        leftMotor = new VictorSP(0);
        rightMotor = new VictorSP(1);
        rightMotor.setInverted(true);
    }

    public void drive(double left, double right) {
        leftMotor.set(left);
        rightMotor.set(right);
    }

    public class Drive      extends Command {
        double left, right;
        public Drive(double left, double right) {
            this.left = -left;
            this.right = -right; 
            addRequirements(Drivetrain.this);
        }

        @Override
        public void execute() {
            Drivetrain.this.drive(left, right);
        }

        @Override
        public void end(boolean interrupted) {
            timer.reset();
            timer.start();
            if (timer.get() <= 0.3) {
                Drivetrain.this.drive(0.5, 0.5);
            }
            Drivetrain.this.drive(0, 0);
        }
    }
    
    public void stop() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }
}