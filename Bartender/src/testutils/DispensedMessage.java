package testutils;

import java.util.Map;
import java.util.TreeMap;

public class DispensedMessage implements LogMessage {

	private int amount;

	public DispensedMessage(int amount) {
		this.amount = amount;
	}
	
	@Override
	public Object getData() {
		return amount;
	}
	
	@Override 
	public String toString() {
		return "Dispensed Amount: " + amount;
	}
}
