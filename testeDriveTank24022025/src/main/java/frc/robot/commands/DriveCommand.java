package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    private final DriveSubsystem m_driveSubsystem;
    private final Joystick controleDirecao;

    public DriveCommand(DriveSubsystem driveSubsystem, Joystick joystick) {
        this.m_driveSubsystem = driveSubsystem;
        this.controleDirecao = joystick;

        addRequirements(m_driveSubsystem);
    }

    @Override
    public void execute() {
        double gatEsquerdo = -controleDirecao.getRawAxis(Constants.IO_Constants.AXIS_GATILHO_ESQUERDO);
        double gatDireito = -controleDirecao.getRawAxis(Constants.IO_Constants.AXIS_GATILHO_DIREITO);
        double analogEsquerdo = controleDirecao.getRawAxis(Constants.IO_Constants.AXIS_ANALOG_ESQUERDO);

        double valorGat = gatDireito - gatEsquerdo;
        double ajusteAnalogEsquerdo = analogEsquerdo * Constants.IO_Constants.AJUSTE_ANALOG;

        
        m_driveSubsystem.drive(valorGat, ajusteAnalogEsquerdo);
    }
    @Override
    public void end(boolean interrupted) {
        m_driveSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
