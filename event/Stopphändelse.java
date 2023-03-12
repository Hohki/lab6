package lab6.event;

import lab6.state.Kunder;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

public class Stopphändelse extends Event{
	double tid;
	Kunder kund;
	public Stopphändelse(double tid, Kunder kund) {
		super("Stopp", tid, kund);
	}

	@Override
	public void effect() {
		state.stopSim();
	}
	
}
