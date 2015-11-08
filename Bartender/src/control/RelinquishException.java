package control;

public class RelinquishException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StateChangeEvent stateChangeEvent;
	
	public RelinquishException(StateChangeEvent stateChangeEvent) {
		super();
		this.stateChangeEvent = stateChangeEvent;
	}
	
	public StateChangeEvent getStateChangeEvent() {
		return this.stateChangeEvent;
	}
}
