package lab6.event;

import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

public class Starthändelse extends Event{
	public Starthändelse() {
		super("Start");
	}

	@Override
	public void effect() {
		eventQueue.addEvent(new Starthändelse());
	}
}
