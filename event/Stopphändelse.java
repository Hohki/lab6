/**
 * Albin, Khaled, Gabriel
 * */

package lab6.event;

import lab6.state.Kunder;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

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
