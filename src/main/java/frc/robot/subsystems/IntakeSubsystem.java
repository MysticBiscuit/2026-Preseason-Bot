package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;
// import com.revrobotics.AbsoluteEncoder;
// import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.XboxController;

public class IntakeSubsystem extends SubsystemBase{
    private SparkMax m_coneGoIn;
    private SparkMax m_coneGoInGoUp;

    private final Pigeon2 m_gyro = new Pigeon2(Constants.DriveConstants.kGyroID);

    private boolean coneNoGoIn;

    public IntakeSubsystem(){
        m_coneGoIn = new SparkMax(Constants.DriveConstants.kShooterIndexerCanId, MotorType.kBrushless);
        m_coneGoInGoUp = new SparkMax(Constants.DriveConstants.kShooterCanId, MotorType.kBrushless);

        if (m_coneGoIn.getOutputCurrent() > 0.05) {
            conNoGoIn = true;
        } else {
            conNoGoIn = false;
        }
    }

    public void runConeConsumer(boolean consumeCone, boolean regurgitateCone) {
        if(consumeCone && !coneNoGoIn) {
            m_coneGoIn.set(0.2);
        } else if (regurgitateCone) {
            m_coneGoIn.set(-0.2);
        } else {
            m_coneGoIn.set(0);
        }
    }

    public void runConsumerArm(boolean elevateCone, boolean lowerCone) {
        if(elevateCone) {
            m_coneGoInGoUp.set(0.2);
        } else if (lowerCone) {
            m_coneGoInGoUp.set(-0.2);
        } else {
            m_coneGoInGoUp.set(0);
        }
    }

    @Override
    public void periodic(){
        if (!DriverStation.isAutonomous()){

        }
    }

    public void zeroIt(boolean zero) {
        if (zero) {
            m_gyro.reset();
        }
    }
}