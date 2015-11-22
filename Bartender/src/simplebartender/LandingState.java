package simplebartender;

import hardware.HardwareCapabilities;
import hardware.HardwareEvent;
import control.RelinquishException;
import control.State;
import control.StateChangeEvent;

/*
 * The entrance state for the bartender.  Displays a welcome message.
 * Enter moves to drink selection, other buttons do nothing.
 */
public class LandingState extends State {
	
	public LandingState(HardwareCapabilities hardwareCapabilites) {
		super(hardwareCapabilites);
	}
		
	@Override
	public void handleEntry() {
		hardwareCapabilities.writeToDisplay(SimpleBartenderMessages.LANDING_MENU_MESSAGE);
	}

	@Override
	public void handleEventByState(HardwareEvent event)
			throws RelinquishException {
		switch (event) {
		case ButtonEnter:
			handleButtonEnter();
			break;
		default:
			break;
		}
	}

	private void handleButtonEnter() throws RelinquishException {
		throw new RelinquishException(new StateChangeEvent("Drink Menu", SimpleStateChangeEvent.ToDrinkMenu));
	}
}
