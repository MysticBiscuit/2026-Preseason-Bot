package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.Servo;

public class ElevatorSubsystem extends SubsystemBase{

    private final SparkMax m_elevatorMotorOne;
    private final SparkMax m_elevatorMotorTwo;

    private final DigitalInput m_elevatorTopLimit;
    private final DigitalInput m_elevatorBottomLimit;

    //private boolean m_elevatorFullRequested = false;
    //private boolean m_elevatorAutoRequested = false;

    public ElevatorSubsystem() {

        m_elevatorMotorOne = new SparkMax(Constants.DriveConstants.kElevatorMotorOneCanId, MotorType.kBrushless); 
        m_elevatorMotorTwo = new SparkMax(Constants.DriveConstants.kElevatorMotorTwoCanId, MotorType.kBrushless);

        m_elevatorTopLimit = new DigitalInput(Constants.DriveConstants.dElevatorTopLimitSwitchPort);
        m_elevatorBottomLimit = new DigitalInput(Constants.DriveConstants.kElevatorBottomLimitSwitchPort);

    @Override
    public void periodic() {
    if (!DriverStation.isAutonomous()){
         fullPickUpCommand(m_fullPickUpRequested, m_autoPickUpRequested);
    }

    if (DriverStation.isAutonomous()){
            autoPickUpCommmand(m_fullPickUpRequested, m_autoPickUpRequested)
     }
    }

    private void fullPickUpCommand(boolean m_fullPickUpRequested, boolean m_autoPickUpRequested) {
        if (fullPickUpRequested) {

        }
    }
 }

}