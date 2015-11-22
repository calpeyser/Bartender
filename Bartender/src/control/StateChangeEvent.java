package control;

public class StateChangeEvent {

	private String name;
	private Object data;
	
	public StateChangeEvent(String name, Object data) {
		this.name = name;
		this.data = data;
	}	
	
	public String getName() {
		return name;
	}
	
	public Object getData() {
		return data;
	}
}
