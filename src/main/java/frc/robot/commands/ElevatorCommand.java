package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.Constants;

public class ElevatorCommand extends Command {
    private final ElevatorSubsystem m_elevatorMotorOne;
    private final XboxController m_Controller;

    public IntakeCommand(IntakeSubsystem elevator,XboxController controller) {
        m_elevatorMotorOne = elevator;
        m_Controller = controller;
        addRequirements(elevator);
    }

    @Override
    public void execute() {
      
        m_elevatorMotorOne.elevatorManualCommands(m_Controller.getYButton(),m_Controller.getAButton());
        m_elevatorMotorTwo.elevatorManualCommands(m_Controller.getYButton(),m_Controller.getAButton());
        

    }
}