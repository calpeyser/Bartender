package hardware;

public interface HardwareCapabilities {
	
	/*
	 * Writes the given message to some form of output.
	 */
	public void writeToDisplay(String message);
	
	/*
	 * Dispenses amount from the given canister number.
	 */
	public void dispense(int canisterNumber, int amount);
	
	/*
	 * How many canisters does this piece of hardware have?
	 */
	public int numberOfCanisters();
}
