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

public class IntakeSubsystem extends SubsystemBase{
    private SparkMax m_intakeHug;
    private SparkMax m_intakeFlipper;

    public IntakeSubsystem() {
        m_intakeHug = new SparkMax (Constants.DriveConstants.kIntakeExtenderOneCanId, MotorType.kBrushless);
         m_intakeFlipper = new SparkMax (Constants.DriveConstants.kIntakeExtenderOneCanId, MotorType.kBrushless);


         
    }
}
