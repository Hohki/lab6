package lab6.event;

import lab6.state.Kunder;
import lab6.state.State;
import lab6.tools.Pair;

public abstract class Event {
	Pair pair;
	EventQueue eventQueue = new EventQueue();
	public Event(Pair pair) {
		this.pair = pair;
	}

	public abstract void effect(State state);

	public double tid() {
		return this.pair.tid();
	}

	public Kunder kund() {
		return this.pair.kund();
	}
}