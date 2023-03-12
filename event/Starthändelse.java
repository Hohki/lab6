package lab6.event;

import lab6.state.State;
import lab6.tools.Pair;

public class Starthändelse extends Event{

	public Starthändelse(State state, String str, Pair pair) {
		super(state, str, pair);
		
	}

	@Override
	public void effect(State state) {
		
	}

}
