/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import lab6.state.Kunder;

public class BetalningsEvent extends Event {
	private double tid;

	/**
	 * Constructer for betalningEvent, an object that holds the time of the event
	 * and the customer that will do that event.
	 *
	 * @param tid Time when the event is going to occur.
	 * @param kund The customer that the event is going to happen to.
	 */
	public BetalningsEvent(double tid, Kunder kund) {
		super("Betalning", tid, kund);
		this.tid = tid;
	}

	/**
	 * Lägger till antal kunder som betalat Ökar antal lediga kassor om ingen står i
	 * kön Lägger annars till en ny betalningshändelse för den kund som står först i
	 * kön.
	 *
	 */
	@Override
	public void effect() {
		state.notify(this);
		state.IncreaseNumberOfPayedCustomers();
		state.DecreaseCustomers();
		// Delete current costumer? Queue times?
		if (state.GetQueue().size() == 0) {
			state.IncreaseFreeKassor();

		} else {
			double nextPay = state.GetNextPay(this.tid);
			BetalningsEvent betalningsEvent = new BetalningsEvent(nextPay, state.GetQueue().first()); // First
																												// in
																												// queue
																												// goes
																												// to
																												// pay
			eventQueue.addEvent(betalningsEvent);
			state.GetQueue().removeFirst(); // Decreases queue
		}
	}

}
