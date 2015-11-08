package control;

public abstract class StateManager {

	public abstract State getFirstState();
	
	public abstract State changeState(StateChangeEvent stateChangeEvent);
	
}
