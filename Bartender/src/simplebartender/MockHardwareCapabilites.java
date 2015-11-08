package simplebartender;

import testutils.Log;
import testutils.WroteToDisplayMessage;
import hardware.HardwareCapabilities;

public class MockHardwareCapabilites implements HardwareCapabilities {

	private Log log;
	
	public MockHardwareCapabilites() {
		this.log = new Log();
	}
	
	@Override
	public void writeToDisplay(String message) {
		log.log(new WroteToDisplayMessage(message));
	}

	@Override
	public void dispense(int canisterNumber, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public int numberOfCanisters() {
		return 5;
	}

}
