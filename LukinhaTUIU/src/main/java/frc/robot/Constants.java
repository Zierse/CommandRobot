// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class DriveTeleOp{
    public static CANSparkMax MotorNEO2 = new CANSparkMax(2, MotorType.kBrushless);
    public static CANSparkMax MotorNEO3 = new CANSparkMax(3, MotorType.kBrushless);
    public static CANSparkMax MotorNEO4 = new CANSparkMax(4, MotorType.kBrushless);
    public static CANSparkMax MotorNEO5 = new CANSparkMax(5, MotorType.kBrushless);
  }

  public static class ControlarMotores{
    public static Joystick Logitech = new Joystick(0);
  
  }

  public static class Encoders{
    
    public final static RelativeEncoder EncoderEsquerdoFrontal = Constants.DriveTeleOp.MotorNEO2.getEncoder();
    public final static RelativeEncoder EncoderEsquerdoTraseiro = Constants.DriveTeleOp.MotorNEO4.getEncoder();
    public final static RelativeEncoder EncoderDireitoFrontal = Constants.DriveTeleOp.MotorNEO3.getEncoder();
    public final static RelativeEncoder EncoderDireitoTraseiro = Constants.DriveTeleOp.MotorNEO5.getEncoder();

  }
}

