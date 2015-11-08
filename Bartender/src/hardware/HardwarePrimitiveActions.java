package hardware;

public interface HardwarePrimitiveActions {

	/*
	 * Writes the given message to some form of output.
	 */
	public void writeToDisplay(String message);

	/* 
	 * Rotates the servo to the given degree.
	 */
	public void rotateServo(int degrees);
	
	/*
	 * Dispenses from the current canister.
	 */
	public void dispense(int amount);
}
