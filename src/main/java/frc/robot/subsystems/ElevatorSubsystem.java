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

    //private boolean m_elevatorFullRequested = false;
    //private boolean m_elevatorAutoRequested = false;

    public ElevatorSubsystem() {

        m_elevatorMotorOne = new SparkMax(Constants.DriveConstants.kElevatorMotorOneCanId, MotorType.kBrushless); 

        m_elevatorTopLimit = new DigitalInput(Constants.DriveConstants.dElevatorTopLimitSwitchPort);
        m_elevatorBottomLimit = new DigitalInput(Constants.DriveConstants.kElevatorBottomLimitSwitchPort);
        m_elevatorLevelOneLimit = new DigitalInput(Constants.DriveConstants.kElevatorLevelOneLimitSwitchPort);
        m_elevatorLevelTwoLimit = new DigitalInput(Constants.DriveConstants.kElevatorLevelTwoLimitSwitchPort);
    }

    public void goUp() {
        if (yButton) {
            (climbUpLevel)
           boolean yButton = false;
        };
    }

    public void goDown() {
        if (aButton) {
            (climbDownLevel)
            boolean aButton = false;
        }
    }
    public void goAllUp() {
        if (yButton && xButton) {
            (climbToTop)
            boolean yButton = false
            boolean xbutton = false;
        };
    }

    public void goAllDown() {
        if (aButton && xButton) {
            (climbToBottom)
            boolean aButton = false
            boolean xbutton = false;
        };
    }


    public Command climbUpLevel() {
        return new Command() {

            @Override
            public boolean isFinished() {
                return (m_elevatorLevelOneLimit.get() || m_elevatorLevelTwoLimit.get() || m_elevatorTopLimit.get());
            }            

            @Override
            public void initialize() {}

            @Override
            public void execute() {
                m_elevatorMotorOne.set(0.25)
             }
            
             @Override
             public void end(boolean interuppted) {
                m_elevatorMotorOne.set(0)
             }
        }
    };

 public Command climbDownLevel() {
        return new Command() {

            @Override
            public boolean isFinished() {
                return (m_elevatorLevelOneLimit.get() || m_elevatorLevelTwoLimit.get() || m_elevatorBottomLimit.get());
            }            

            @Override
            public void initialize() {}

            @Override
            public void execute() {
                m_elevatorMotorOne.set(-0.25)
             }
            
             @Override
             public void end(boolean interuppted) {
                m_elevatorMotorOne.set(0)
             }
        }
    };

    private Command climbToTop() {
        return new Command() {

            @Override
            public boolean isFinished() {
                return (m_elevatorTopLimit.
            }

            @Override
            public void initialize() {}

            @Override
            public void execute() {
                m_elevatorMotorOne.set(0.25)
            }

            @Override
            public void end(boolean interuppted) {
                m_elevatorMotorOne.set(0)
            }
        }
    };

    private Command climbToBottom() {
        return new Command() {

            @Override
            public boolean isFinished() {
                return m_elevatorTopLimit
            }

            @Override
            public void initialize() {}

            @Override
            public void execute() {
                m_elevatorMotorOne.set(-0.25)
            }

            @Override
            public void end(boolean interuppted) {
                m_elevatorMotorOne.set(0)
            }
        }
    };
};