// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {

  private final ArmSubsystem m_armSubsystem = new ArmSubsystem();
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final Joystick controleDirecao = new Joystick(Constants.IO_Constants.JOYSTICK_PORT_DRIVE);

  private final Joystick controleOperador = new Joystick(Constants.IO_Constants.JOYSTICK_PORT_OPERATOR);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, controleDirecao));
    
    m_armSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, controleOperador));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
