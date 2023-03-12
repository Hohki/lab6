package lab6.event;

import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

public class Starthändelse extends Event{

	public Starthändelse(State state, String str) {
		super(state, str);
	}

	@Override
	public void effect(StoreState state) {
		
	}
}
