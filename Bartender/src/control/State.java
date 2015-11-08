package control;

import hardware.HardwareCapabilities;
import hardware.HardwareEvent;

/*
 * A HardwareEventHandler can relinquish control to another instance of class State.
 * Meant to represent the different "states" of the bartender, for example, 
 * different sorts of menus.
 */
public abstract class State {

	protected HardwareCapabilities hardwareCapabilites;
	
	public State(HardwareCapabilities hardwareCapabilites) {
		this.hardwareCapabilites = hardwareCapabilites;
	}
	
	public abstract void handleEventByState(HardwareEvent event) throws RelinquishException;
		
}
