package control;

import hardware.HardwareEvent;

public final class BartenderController implements HardwareEventHandler {

	private StateManager stateManager;
	private State currentState;
	
	
	public BartenderController(StateManager stateManager) {
		this.stateManager = stateManager;
		this.currentState = stateManager.getFirstState();
	}
	
	@Override
	public void handleEvent(HardwareEvent event) {
		try {
			currentState.handleEventByState(event);
		}
		catch (RelinquishException e) {
			currentState = stateManager.changeState(e.getStateChangeEvent());
		}
	}
	
	public State getCurrentState() {
		return currentState;
	}
}
