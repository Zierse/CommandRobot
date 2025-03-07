package frc.robot;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants.DriveConstants;

public class MotorConfig {
    
    private final SparkMax motorSuperiorEsquerdoLider = new SparkMax(DriveConstants.MOTOR_SUPERIOR_ESQUERDO_LIDER, MotorType.kBrushless);
    private final SparkMax motorInferiorEsquerdoSeguidor = new SparkMax(DriveConstants.MOTOR_SUPERIOR_ESQUERDO_SEGUIDOR, MotorType.kBrushless);
    private final SparkMax motorSuperiorDireitoLider = new SparkMax(DriveConstants.MOTOR_SUPERIOR_DIREITO_LIDER, MotorType.kBrushless);
    private final SparkMax motorInferiorDireitoSeguidor = new SparkMax(DriveConstants.MOTOR_SUPERIOR_DIREITO_SEGUIDOR, MotorType.kBrushless);


    private final SparkMaxConfig configGlobal = new SparkMaxConfig();
    private final SparkMaxConfig configMotorDireitoLider = new SparkMaxConfig();
    private final SparkMaxConfig configMotorDireitoSeg = new SparkMaxConfig();
    private final SparkMaxConfig configMotorEsquerdoSeg = new SparkMaxConfig();


    public MotorConfig(){

        configGlobal
        .smartCurrentLimit(Constants.ConfigMotores.CURRENT_LIMIT)
        .idleMode(IdleMode.kBrake);
            
    configMotorDireitoLider
        .apply(configGlobal)
        .inverted(true);

    configMotorEsquerdoSeg
        .apply(configGlobal)
        .inverted(false)
        .follow(motorSuperiorEsquerdoLider);
            
    configMotorDireitoSeg
        .apply(configGlobal)
        .follow(motorSuperiorDireitoLider);
            
    motorSuperiorEsquerdoLider.configure(configGlobal, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    motorInferiorEsquerdoSeguidor.configure(configMotorEsquerdoSeg, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    motorSuperiorDireitoLider.configure(configMotorDireitoLider, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    motorInferiorDireitoSeguidor.configure(configMotorDireitoSeg, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);


    }
    
}
