package control;

import hardware.HardwareEvent;

public interface HardwareEventHandler {

	public void handleEvent(HardwareEvent event);
	
}
