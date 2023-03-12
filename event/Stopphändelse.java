package lab6.event;

import lab6.state.State;
import lab6.tools.Pair;

public class Stopphändelse extends Event{

	public Stopphändelse(State state, String str, Pair pair, EventQueue queue) {
		super(state, str, pair, queue);
	}

	@Override
	public void effect(State state) {
		state.stopSim();
	}

	
}
