package simplebartender;

import testutils.DispensedMessage;
import testutils.Log;
import testutils.RotatedServoMessage;
import testutils.WroteToDisplayMessage;
import hardware.HardwarePrimitiveActions;

public class MockHardwarePrimitiveActions implements HardwarePrimitiveActions {

	private Log log;
	
	public MockHardwarePrimitiveActions() {
		this.log = new Log();
	}
	
	@Override
	public void writeToDisplay(String message) {
		log.log(new WroteToDisplayMessage(message));
	}

	@Override
	public void rotateServo(int degrees) {
		log.log(new RotatedServoMessage(degrees));
	}

	@Override
	public void dispense(int amount) {
		log.log(new DispensedMessage(amount));
	}
}
