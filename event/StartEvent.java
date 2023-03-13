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
	 * Konstruktor för Starthändelse.
	 * 
	 * @param tid
	 */
	public StartEvent(double tid) {
		super("Start", tid);
	}

	/**
	 * Lägger till en första Ankomsthändelse. Öppnar butiken.
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
