package lab6.state;
import java.util.Observable;

public abstract class State extends Observable {
	private int simState = 0;
	public boolean simStop = false;
	protected double simTime;
	
	public State() {
		this.simStop = false;
		this.simTime = 0.0d;
	}
	
	public int addTime(int time) {
		simState = simState + time;
		return simState;
	}
	
	public double CurrentTime() {
		return simTime;
	}
	
	public void stopSim() {
		simStop = true;
	}
	
	public void callObservers() {
		setChanged();
		notifyObservers();
	}

}
