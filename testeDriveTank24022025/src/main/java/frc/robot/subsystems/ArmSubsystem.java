package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    
    private final SparkMax armMotor;

    public ArmSubsystem() {
        armMotor = new SparkMax(Constants.ArmConstants.ARM_MOTOR_ID, MotorType.kBrushless);
        
        SparkMaxConfig armConfig = new SparkMaxConfig();
        armConfig
            .smartCurrentLimit(ArmConstants.ARM_MOTOR_CURRENT_LIMIT)
            .idleMode(IdleMode.kBrake);

        armMotor.configure(armConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {

    }

    public void runArm(double speed){
        armMotor.set(speed);
    }
}
