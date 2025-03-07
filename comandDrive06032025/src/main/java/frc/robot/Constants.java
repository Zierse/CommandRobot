package frc.robot;

public class Constants {
    
    public static final class DriveConstants {

        public static final int MOTOR_SUPERIOR_ESQUERDO_LIDER = 2;
        public static final int MOTOR_SUPERIOR_ESQUERDO_SEGUIDOR = 3;

        public static final int MOTOR_SUPERIOR_DIREITO_LIDER = 4;
        public static final int MOTOR_SUPERIOR_DIREITO_SEGUIDOR = 5;

        public static final double LARGURA_ENTRE_RODAS = 0.455;
    }
    public static final class IO_Constants {

        public static final int JOYSTICK_PORT_DRIVE = 0;
        public static final int JOYSTICK_PORT_OPERATOR = 1;

        public static final int AXIS_GATILHO_ESQUERDO = 2;
        public static final int AXIS_GATILHO_DIREITO = 3;
        public static final int AXIS_ANALOG_ESQUERDO = 0;

        public static final double AJUSTE_ANALOG = 0.5;
    }

    public static final class ConfigMotores {
        
        public static final int CURRENT_LIMIT = 30;
    }

    public static final class AutonomousConstants {

        public static final double TURN_TOLERANCE = 0.5;
        public static final double TOLERANCE_METERS = 0.1;
        public static final double kMaxSppedmetersPerSecond = 1.5; //Velocidade máxima por segundos
        public static final double kMaxAccelerationMetersPerSecondSquared = 1.0; //Aceleração Máxima

        public static final double kRamseteB = 2.2; //Ajuste conforme necessário
        public static final double kRamseteZeta = 0.7; //Ajuste conforme

    }

    public static final class PIDConstants {

        
    }
}
