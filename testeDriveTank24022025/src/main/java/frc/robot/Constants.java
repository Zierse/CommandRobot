package frc.robot;

public class Constants {
    
    public static final class DriveConstants {

        public static final int MOTOR_SUPERIOR_ESQUERDO_LIDER = 2;
        public static final int MOTOR_SUPERIOR_ESQUERDO_SEGUIDOR = 3;

        public static final int MOTOR_SUPERIOR_DIREITO_LIDER = 4;
        public static final int MOTOR_SUPERIOR_DIREITO_SEGUIDOR = 5;
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

    public static final class ArmConstants {
        
        public static final int ARM_MOTOR_ID = 5;
        public static final int ARM_MOTOR_CURRENT_LIMIT = 60;
        public static final double ARM_MOTOR_VOLTAGE_COMP = 10;
        public static final double ARM_SPEED_DOWN = 0.4;
        public static final double ARM_SPEED_UP = -0.4;
        public static final double ARM_HOLD_DOWN = 0.1;
        public static final double ARM_HOLD_UP = -0.15;
    }
}
