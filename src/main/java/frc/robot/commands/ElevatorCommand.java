ackage frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.Constants;

private final ElevatorSubsystem m_elevatorMotorOne;
    private final XboxController m_Controller;

    public IntakeCommand(IntakeSubsystem elevator,XboxController controller) {
        m_elevatorMotorOne = elevator;
        m_Controller = controller;
        addRequirements(elevator);

    @Override
    public void execute() {
        m_elevator.climbUp(m_Controller.getYButton());
        m_elevator.climbDown(m_Controller.getAButton());
    
        m_elevator.updateWithControls(m_Controller.getLeftTriggerAxis() > 0.8, m_Controller.getRightTriggerAxis() > 0.8);
    }
};