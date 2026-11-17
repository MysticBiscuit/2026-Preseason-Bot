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
<<<<<<< Updated upstream
        m_elevatorMotorTwo = new SparkMax(Constants.DriveConstants.kElevatorMotorTwoCanId, MotorType.kBrushless);
=======
>>>>>>> Stashed changes

        m_elevatorTopLimit = new DigitalInput(Constants.DriveConstants.dElevatorTopLimitSwitchPort);
        m_elevatorBottomLimit = new DigitalInput(Constants.DriveConstants.kElevatorBottomLimitSwitchPort);
        m_elevatorLevelOneLimit = new DigitalInput(Constants.DriveConstants.kElevatorLevelOneLimitSwitchPort);
        m_elevatorLevelTwoLimit = new DigitalInput(Constants.DriveConstants.kElevatorLevelTwoLimitSwitchPort);
    }

<<<<<<< Updated upstream
    @Override
    public void periodic() {
    if (!DriverStation.isAutonomous()){
         fullPickUpCommand(m_fullPickUpRequested, m_autoPickUpRequested);
    }

    if (DriverStation.isAutonomous()){
            autoPickUpCommmand(m_fullPickUpRequested, m_autoPickUpRequested);
     }
    }

    private void fullPickUpCommand(boolean m_fullPickUpRequested, boolean m_autoPickUpRequested) {
        if (fullPickUpRequested) {
            climbUpLevel();        
        }
    }

    private void autoPickUpCommand(boolean m_fullPickUpRequested, boolean m_autoPickUpRequested) {
        if (autoPickUpRequested)
    }
    private command climbUpLevel() {
        return new Command() {

            @Override
            public boolean isFinished() {}            
=======
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
>>>>>>> Stashed changes

            @Override
            public void initialize() {}

            @Override
            public void execute() {
<<<<<<< Updated upstream
            if (m_elevatorBottomLimit.get() && (m_elevatorMotorOne.get(0) && m_elevatorMotorTwo.get(0))) {
                    m_elevatorMotorOne.set(0.25);
                    m_elevatorMotorTwo.set(-0.25);
            } else if (!m_elevatorBottomLimit.get() || !m_elevatorLevelOneLimit.get() && (elevatorMotorOneSpeed + elevatorMotorTwoSpeed == 0)) {
                m_elevatorMotorOne.set(0.25);
                m_elevatorMotorTwo.set(-0.25);
=======
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
                return m_elevatorTopLimit
            }

            @Override
            public void initialize() {}

            @Override
            public void execute() {
                m_elevatorMotorOne.set(0.25)
>>>>>>> Stashed changes
            }

            @Override
            public void end(boolean interuppted) {
<<<<<<< Updated upstream
                m_elevatorMotorOne.set(0);
            }
           
        };

        private command command climbToTop() {
            return new Command() {

                @Override
            }
        }
    };
};
=======
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
>>>>>>> Stashed changes
};