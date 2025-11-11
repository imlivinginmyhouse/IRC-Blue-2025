package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private final VictorSP six_seven_motor;
    
        public Arm(){
            six_seven_motor = new VictorSP(2);
        }
    
        public void lift(double six_seven_direction) {
            six_seven_motor.set(six_seven_direction);
    }
    public void stop() {
        six_seven_motor.set(0);
    }
}