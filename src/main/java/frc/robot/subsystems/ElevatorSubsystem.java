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
    private final DigitalInput m_elevatorLevelOneLimit;
    private final DigitalInput m_elevatorLevelTwoLimit;

    public double elevatorMotorOneSpeed = m_elevatorMotorOne.get();
    public double elevatorMotorTwoSpeed = m_elevatorMotorTwo.get();

    private boolean m_climbLevelOneRequested = false;
    private boolean m_climbLevelTwoRequested = false;

    //private boolean m_elevatorFullRequested = false;
    //private boolean m_elevatorAutoRequested = false;

    public ElevatorSubsystem() {

        m_elevatorMotorOne = new SparkMax(Constants.DriveConstants.kElevatorMotorOneCanId, MotorType.kBrushless); 

        m_elevatorTopLimit = new DigitalInput(Constants.DriveConstants.dElevatorTopLimitSwitchPort);
        m_elevatorBottomLimit = new DigitalInput(Constants.DriveConstants.kElevatorBottomLimitSwitchPort);
        m_elevatorLevelOneLimit = new DigitalInput(Constants.DriveConstants.kElevatorLevelOneLimitSwitchPort);
        m_elevatorLevelTwoLimit = new DigitalInput(Constants.DriveConstants.kElevatorLevelTwoLimitSwitchPort);
    }


    public Command climbLevelOne(boolean climbLevelOneRequested) {
        if (climbLevelOneRequested) {
            return new Command() {

            @Override
            public boolean isFinished() {
                return m_elevatorLevelOneLimit.get() || m_elevatorTopLimit.get();
            }

            @Override
            public void initialize() {}

            @Override
            public void execute() {
                m_elevatorMotorOne.set(0.25);
            }

            @Override
            public void end(boolean interuppted)  {
                m_elevatorMotorOne.set(0);
                boolean climbLevelOneRequested = false;
            }
        }
        } else {
            return Commands.none()
        }
    }

    public Command climbLevelTwo(boolean climbLevelTwoRequested) {
        if (climbLevelTwoRequested) {
            return new Command() {

            @Override
            public boolean isFinished() {
                return m_elevatorLevelTwoLimit.get() || m_elevatorBottomLimit.get()
            }

            @Override
            public void initialize() {}

            @Override
            public void execute() {
                m_elevatorMotorOne.set(-0.25);
            }

            @Override
            public void end(boolean interuppted)  {
                m_elevatorMotorOne.set(0);
                boolean climbLevelTwoRequested = false;
            }
        }
        } else {
            return Commands.none()
        }
    }


    public Command climbUp() {
        return new Command() {

            @Override
            public boolean isFinished() {
                return (!m_Controller.getYButton() || m_elevatorTopLimit.get())
            }

            @Override
            public void initialize() {}

            @Override
            public void execute() {
                m_elevatorMotorOne.set(0.25);
            }

            @Override
            public void end(boolean interuppted)  {
                m_elevatorMotorOne.set(0);
            }
        } else {
            return Commands.none()
        }
    }

    public Command climbDown() {
        return new Command() {

            @Override
            public boolean isFinished() {
                return (!m_Controller.getAButton() || m_elevatorBottomLimit.get())
            }

            @Override
            public void initialize() {}

            @Override
            public void execute() {
                m_elevatorMotorOne.set(-0.25);
            }

            @Override
            public void end(boolean interuppted)  {
                m_elevatorMotorOne.set(0);
            }
        } else {
            return Commands.none()
        }
    }

    public void updateWithControls(boolean climbLevelOneRequested, boolean climbLevelTwoRquested) {
        m_climbLevelOneRequested = climbLevelOneRequested;
        m_climbLevelTwoRequested = climbLevelTwoRequested;
    }
}