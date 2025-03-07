package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    private final SparkMax motorSuperiorEsquerdoLider = new SparkMax(DriveConstants.MOTOR_SUPERIOR_ESQUERDO_LIDER, MotorType.kBrushless);
    private final SparkMax motorInferiorEsquerdoSeguidor = new SparkMax(DriveConstants.MOTOR_SUPERIOR_ESQUERDO_SEGUIDOR, MotorType.kBrushless);
    private final SparkMax motorSuperiorDireitoLider = new SparkMax(DriveConstants.MOTOR_SUPERIOR_DIREITO_LIDER, MotorType.kBrushless);
    private final SparkMax motorInferiorDireitoSeguidor = new SparkMax(DriveConstants.MOTOR_SUPERIOR_DIREITO_SEGUIDOR, MotorType.kBrushless);

    private final RelativeEncoder enconderSuperiorDireito = motorSuperiorDireitoLider.getEncoder();
    private final RelativeEncoder enconderInferiorDireito = motorInferiorDireitoSeguidor.getEncoder();

    private final RelativeEncoder enconderSuperiorEsquerdo = motorSuperiorEsquerdoLider.getEncoder();
    private final RelativeEncoder enconderInferiorEsquerdo = motorInferiorEsquerdoSeguidor.getEncoder();
    
    private final Pigeon2 gyro = new Pigeon2(0);

    private final DifferentialDriveKinematics kimenatics = new DifferentialDriveKinematics(0.46);

    private final DifferentialDriveOdometry odometriaEsquerda = new DifferentialDriveOdometry(getHeading() , enconderSuperiorEsquerdo.getPosition(), enconderInferiorEsquerdo.getPosition());

    private final DifferentialDriveOdometry odometriaDireita = new DifferentialDriveOdometry(getHeading() , enconderSuperiorDireito.getPosition(), enconderInferiorDireito.getPosition());

public DriveSubsystem() {

    SparkMaxConfig configGlobal = new SparkMaxConfig();
    SparkMaxConfig configMotorDireitoLider = new SparkMaxConfig();
    SparkMaxConfig configMotorDireitoSeg = new SparkMaxConfig();
    SparkMaxConfig configMotorEsquerdoSeg = new SparkMaxConfig();

    SparkMaxConfig configEnconder = new SparkMaxConfig();

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
            
            
    private Rotation2d getHeading() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getHeading'");
}


    public void drive(double FrenteTras, double EsquerdaDireita) {
        motorSuperiorEsquerdoLider.set(FrenteTras + EsquerdaDireita);
        motorSuperiorDireitoLider.set(FrenteTras - EsquerdaDireita);
    }

    public void stop() {
        motorSuperiorEsquerdoLider.set(0);
        motorSuperiorDireitoLider.set(0);
    }
}
