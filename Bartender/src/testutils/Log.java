package testutils;

import java.util.ArrayList;
import java.util.List;

public final class Log {
	
	private List<LogMessage> messages;

	public Log() {
		this.messages = new ArrayList<LogMessage>();
	}
	
	public void log(LogMessage message) {
		messages.add(message);
	}
	
	public List<LogMessage> getLog() {
		return messages;
	}
	
}
