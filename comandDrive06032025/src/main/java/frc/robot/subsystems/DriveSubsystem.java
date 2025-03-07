package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.config.RobotConfig;
import com.pathplanner.lib.controllers.PPLTVController;
import com.pathplanner.lib.controllers.PathFollowingController;
import com.pathplanner.lib.trajectory.PathPlannerTrajectory;
import com.pathplanner.lib.util.DriveFeedforwards;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    private final SparkMax motorSuperiorEsquerdoLider = new SparkMax(DriveConstants.MOTOR_SUPERIOR_ESQUERDO_LIDER, MotorType.kBrushless);
    private final SparkMax motorInferiorEsquerdoSeguidor = new SparkMax(DriveConstants.MOTOR_SUPERIOR_ESQUERDO_SEGUIDOR, MotorType.kBrushless);
    private final SparkMax motorSuperiorDireitoLider = new SparkMax(DriveConstants.MOTOR_SUPERIOR_DIREITO_LIDER, MotorType.kBrushless);
    private final SparkMax motorInferiorDireitoSeguidor = new SparkMax(DriveConstants.MOTOR_SUPERIOR_DIREITO_SEGUIDOR, MotorType.kBrushless);

    public static Pigeon2 Pigeon = new Pigeon2(0);

    private static DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(getRotation2d(), getDistance(), getDistance());
    public final DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.DriveConstants.LARGURA_ENTRE_RODAS);

    //Admissão de variaveis para velocidades inciais
    private ChassisSpeeds startingSpeeds = new ChassisSpeeds(0, 0, 0);


public DriveSubsystem() {


    
}
    private static Distance getDistance() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getDistance'");
}
    private static Rotation2d getRotation2d() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getRotation2d'");
}
    public void movimentacaoRobo(double FrenteTras, double EsquerdaDireita) {
        
        motorSuperiorEsquerdoLider.set(FrenteTras + EsquerdaDireita);
        motorInferiorEsquerdoSeguidor.set(FrenteTras + EsquerdaDireita);

        motorSuperiorDireitoLider.set(FrenteTras - EsquerdaDireita);
        motorInferiorDireitoSeguidor.set(FrenteTras - EsquerdaDireita);


    }

    public void stop() {
        motorSuperiorEsquerdoLider.set(0);
        motorSuperiorDireitoLider.set(0);
    }

    private void Drive(ChassisSpeeds chassisspeeds1, DriveFeedforwards drivefeedforwards2) {
    }
    private ChassisSpeeds getRobotRelativeSpeeds() {
        return null;
    }
    private Pose2d PoseSupplier() {
        return null;
    }
    private void resetPose(Pose2d pose2d1) {
    }
}
