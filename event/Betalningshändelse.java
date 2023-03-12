package lab6.event;

import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

public class Betalningshändelse extends Event{

	public Betalningshändelse(State state, String str, Pair pair) {
		super(state, str, pair);
	}

	@Override
	public void effect(StoreState state) {
		
	}

}
