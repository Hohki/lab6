/**
 * Albin, Khaled, Gabriel
 * */

package lab6.event;

import lab6.state.CustomerFactory;
import lab6.state.Kunder;

public class Starthändelse extends Event{
	public Starthändelse(double tid) {
		super("Start", tid);
	}

	@Override
	public void effect() {
		state.SetStoreState(true);
		eventQueue.addEvent(this);
		double nextArrival = state.GetNextArrival(this.tid());
		Kunder newKund = new Kunder(new CustomerFactory().getNumber());
		Ankomsthändelse ankomsthändelse = new Ankomsthändelse(nextArrival, newKund);
		eventQueue.addEvent(ankomsthändelse);
		eventQueue.addEvent(new Stängningshändelse(state.GetCloseTime()));
	}
}
