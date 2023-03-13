package lab6.event;

public class Stopphändelse extends Event{
	double tid;
	public Stopphändelse(double tid) {
		super("Stopp", tid);
	}

	@Override
	public void effect() {
		state.notify(this);
		state.stopSim();
	}
	
}
