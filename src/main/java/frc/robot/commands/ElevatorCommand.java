package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.Constants;

public class ElevatorCommand extends Command {
    private final ElevatorSubsystem m_elevatorMotorOne;
    private final XboxController m_Controller;

<<<<<<< Updated upstream
    public IntakeCommand(IntakeSubsystem elevator,XboxController controller) {
=======
    public ElevatorCommand(ElevatorSubsystem elevator,XboxController controller) {
>>>>>>> Stashed changes
        m_elevatorMotorOne = elevator;
        m_Controller = controller;
        addRequirements(elevator);
    }

    @Override
    public void execute() {
<<<<<<< Updated upstream
      
        m_elevatorMotorOne.elevatorManualCommands(m_Controller.getYButton(),m_Controller.getAButton());
        m_elevatorMotorTwo.elevatorManualCommands(m_Controller.getYButton(),m_Controller.getAButton());
        

    }
=======

        boolean aButton = m_Controller.getAButton();
        boolean yButton = m_Controller.getYButton();
        boolean xButton = m_Controler.getXButton()
    }

    
>>>>>>> Stashed changes
}