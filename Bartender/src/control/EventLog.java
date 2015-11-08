package control;

import hardware.HardwareEvent;

import java.util.ArrayList;
import java.util.List;

public final class EventLog {

	private List<HardwareEvent> eventList;
	
	public EventLog() {
		eventList = new ArrayList<HardwareEvent>();
	}
	
	public void logEvent(HardwareEvent event) {
		eventList.add(event);
	}
	
	public boolean isEmpty() {
		return eventList.isEmpty();
	}
	
	public List<HardwareEvent> getEventList() {
		return this.eventList;
	}
}
