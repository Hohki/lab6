package lab6.event;

import lab6.state.Kunder;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

public class Stängningshändelse extends Event {
	private double tid;

	public Stängningshändelse(double tid) {
		super("Stängning", tid);
		this.tid = tid;
	}

	@Override
	public void effect() {
		state.SetStoreState(false);
		state.notify(this);
	}

}
