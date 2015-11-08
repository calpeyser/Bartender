package hardware;

import control.HardwareEventHandler;


public abstract class Hardware {

	protected HardwareEventHandler hardwareEventHandler;
	
	public Hardware(HardwareEventHandler hardwareEventHandler) {
		this.hardwareEventHandler = hardwareEventHandler;
	}
}
