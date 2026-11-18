 private final ElevatorSubsystem m_elevatorMotorOne;
    private final XboxController m_Controller;

    public IntakeCommand(IntakeSubsystem elevator,XboxController controller) {
        m_elevatorMotorOne = elevator;
        m_Controller = controller;
        addRequirements(elevator);

public class ElevatorCommand extends Command {

        boolean aButton = m_Controller.getAButton();
        boolean yButton = m_Controller.getYButton();
        boolean xButton = m_Controler.getXButton()
    }