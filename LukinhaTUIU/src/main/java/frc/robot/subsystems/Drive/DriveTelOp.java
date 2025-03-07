package frc.robot.subsystems.Drive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTelOp extends SubsystemBase{  //Criação do subsistema para dirigir no teleoperacao do robo foi extendido a subsistema.
    private static AHRS Nave;
    
    

  
    public DriveTelOp(){ //
        Nave = new AHRS(SPI.Port.kMXP);
        Constants.DriveTeleOp.MotorNEO3.setInverted(true);
        Constants.DriveTeleOp.MotorNEO5.follow(Constants.DriveTeleOp.MotorNEO3);
    }

    public void Dirigir(){
        double butttonRT = Constants.ControlarMotores.Logitech.getRawAxis(3);
        double butttonLT = Constants.ControlarMotores.Logitech.getRawAxis(2);
        boolean buttonA = Constants.ControlarMotores.Logitech.getRawButton(1);
        double AnalogEsquerdo = Constants.ControlarMotores.Logitech.getRawAxis(0);

        Constants.DriveTeleOp.MotorNEO4.set((butttonRT - butttonLT) + (AnalogEsquerdo));
        Constants.DriveTeleOp.MotorNEO2.set((butttonRT - butttonLT) + (AnalogEsquerdo));
        Constants.DriveTeleOp.MotorNEO3.set((butttonRT - butttonLT) - (AnalogEsquerdo));
        Constants.DriveTeleOp.MotorNEO5.set((butttonRT - butttonLT) - (AnalogEsquerdo));

        if (buttonA) {
            ResetarEncoder();
        }
    }

    public double getPositionRight(){
        double EncoderDireito = ((Constants.Encoders.EncoderDireitoFrontal.getPosition() + Constants.Encoders.EncoderDireitoTraseiro.getPosition())/2)*-1;

        return EncoderDireito;
    }

     public double getPositionLeft(){
        double EncoderEsquerdo = ((Constants.Encoders.EncoderEsquerdoFrontal.getPosition() + Constants.Encoders.EncoderEsquerdoTraseiro.getPosition())/2)*-1;

        return EncoderEsquerdo;
    }
    public void ResetarEncoder(){

        Constants.Encoders.EncoderDireitoFrontal.setPosition(0.0);
        Constants.Encoders.EncoderDireitoTraseiro.setPosition(0.0);
        Constants.Encoders.EncoderEsquerdoFrontal.setPosition(0.0);
        Constants.Encoders.EncoderEsquerdoTraseiro.setPosition(0.0);

    }
        public double getAngulo(){

        return Nave.getYaw();
        }
    

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Encoder Direito", getPositionRight());
        SmartDashboard.putNumber("Encoder Esquerdo", getPositionLeft());

        SmartDashboard.putNumber("NAVE", getAngulo());
        SmartDashboard.putBoolean("NAVE Conectado", Nave.isConnected());

    }
}
