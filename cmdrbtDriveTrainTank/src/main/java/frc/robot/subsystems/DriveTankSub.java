// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTankSub extends SubsystemBase {

  public final SparkMax motorSuperiorEsquerdoLider = new SparkMax(2, MotorType.kBrushless);
  public final SparkMax motorInferiorEsquerdoSeg = new SparkMax(3, MotorType.kBrushless);
  public final SparkMax motorSuperiorDireitoLider = new SparkMax(4, MotorType.kBrushless);
  public final SparkMax motorInferiorDireitoSeg = new SparkMax(5, MotorType.kBrushless);

  public DriveTankSub() {
    
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
