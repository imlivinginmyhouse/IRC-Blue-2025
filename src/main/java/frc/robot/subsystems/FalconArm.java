package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FalconArm extends SubsystemBase{
    private TalonFX falcon;
    private PositionVoltage positionVoltage;

    public FalconArm() {
        falcon = new TalonFX(3);
        Slot0Configs config = new Slot0Configs();
        config.kP = Constants.ArmConstants.kP;
        config.kI = Constants.ArmConstants.kI;
        config.kD = Constants.ArmConstants.kD;
        falcon.getConfigurator().apply(config);
        positionVoltage = new PositionVoltage(0).withSlot(0);
    }

    public void setGoalPosition(double position) {
        falcon.setControl(positionVoltage.withPosition(position));
    }

    public void periodic() {
        //System.out.println(falcon.getPosition().getValueAsDouble());
    }
}
