package hardware;

public interface HardwarePrimitiveActions {

	/*
	 * Writes the given message to some form of output.
	 */
	public void writeToDisplay(String message);
	
	/*
	 * Dispenses a given amount from a specified canister.
	 */
	public void dispense(int canisterNumber, int amount);
}
