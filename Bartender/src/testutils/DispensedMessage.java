package testutils;

import java.util.Map;
import java.util.TreeMap;

public class DispensedMessage implements LogMessage {

	private int canisterNumber;
	private int amount;
	
	public DispensedMessage(int canisterNumber, int amount) {
		this.canisterNumber = canisterNumber;
		this.amount = amount;
	}
	
	@Override
	public Object getData() {
		return this;
	}
	
	@Override 
	public String toString() {
		return "Dispensed Amount: " + amount + " from canister " + canisterNumber;
	}
	
	public int getCanisterNumber() {
		return canisterNumber;
	}
	
	public int getAmount() {
		return amount;
	}
	
}
