package control;

import hardware.HardwareCapabilities;
import hardware.HardwareEvent;

import java.util.Set;

public final class BartenderController implements HardwareEventHandler {

	private StateManager stateManager;
	private State currentState;
	private HardwareCapabilities hardwareCapabilities;
	
	
	public BartenderController(StateManager stateManager, HardwareCapabilities hardwareCapabilities) {
		this.stateManager = stateManager;
		this.currentState = stateManager.getFirstState();
		this.hardwareCapabilities = hardwareCapabilities;
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
}
