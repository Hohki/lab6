package lab6.event;

import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

public class Stängningshändelse extends Event {

	public Stängningshändelse(String str, Pair pair) {
		super(str, pair);
	
	}

	@Override
	public void effect() {
		
	}

}
