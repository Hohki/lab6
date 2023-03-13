/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import lab6.state.CustomerFactory;
import lab6.state.Kunder;

public class StartEvent extends Event {
	/**
	 * Constructs an object of type StartEvent, that begins the simulation at
	 * currentTime of simulation.
	 * @param tid Time at which the simulation starts.
	 */
	public StartEvent(double tid) {
		super("Start", tid);
	}

	/**
	 * Adds the first ankomstEvent and sets the store state to open.
	 */

	@Override
	public void effect() {
		state.SetStoreState(true);
		eventQueue.addEvent(this);
		double nextArrival = state.GetNextArrival(this.tid());
		Kunder newKund = new Kunder(new CustomerFactory().getNumber());
		AnkomstEvent ankomstEvent = new AnkomstEvent(nextArrival, newKund);
		eventQueue.addEvent(ankomstEvent);
		eventQueue.addEvent(new CloseEvent(state.GetCloseTime()));
	}
}
