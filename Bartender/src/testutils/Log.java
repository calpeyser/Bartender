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
	
	@SuppressWarnings("unchecked")
	public <T> T peek(Class<? extends LogMessage> messageType) {
		if (isEmpty()) {
			throw new RuntimeException("Empty Log");
		}
		for (int logIndex = messages.size() - 1; logIndex >= 0; logIndex--) {
			LogMessage message = messages.get(logIndex);
			if (message.getClass() == messageType) {
				return (T) message;
			}
		}
		return null;
	}
	
	public List<LogMessage> getLog() {
		return messages;
	}
	
	protected boolean isEmpty() {
		return messages.isEmpty();
	}
	
}
