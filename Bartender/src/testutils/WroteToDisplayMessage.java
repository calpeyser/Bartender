package testutils;

public class WroteToDisplayMessage implements LogMessage {

	private String wroteToDisplay;
	
	public WroteToDisplayMessage(String wroteToDisplay) {
		this.wroteToDisplay = wroteToDisplay;
	}
	
	@Override
	public Object getData() {
		return wroteToDisplay;
	}

	@Override
	public String toString() {
		return wroteToDisplay;
	}
	
}
