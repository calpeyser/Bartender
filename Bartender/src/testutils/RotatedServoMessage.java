package testutils;

public class RotatedServoMessage implements LogMessage {

	private int degrees;
	
	public RotatedServoMessage(int degrees) {
		this.degrees = degrees;
	}
	
	@Override
	public Object getData() {
		return degrees;
	}
	
	@Override
	public String toString() {
		return "Rotated Servo to: " + degrees;
	}
}
