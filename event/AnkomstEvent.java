/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import lab6.state.*;
/**
 * 
 * Class for AnkomstEvent
 *
 */
public class AnkomstEvent extends Event {
	private double tid;
	private Kunder kund;

	/**
	 * Constructor for ankomstEvent, it creates an object that holds a time and a customer*
	 * @param tid Time when the event happened.
	 * @param kund Customer that the event happened to.
	 */

	public AnkomstEvent(double tid, Kunder kund) {
		super("Ankomst", tid, kund);
		this.tid = tid;
		this.kund = kund;
	}

	/**
	 * Runs ankomsteventet. Creates the next instance of ankomstEvent while the store
	 * is still open. Creates a plockEvent if there is place for customers in the store.
	 *
	 */

	@Override
	public void effect() {
		state.notify(this);
		if (state.GetStore()) {
			double nextArrival = state.GetNextArrival(this.tid);
			Kunder newKund = new Kunder(new CustomerFactory().getNumber());
			AnkomstEvent ankomstEvent = new AnkomstEvent(nextArrival, newKund);
			eventQueue.addEvent(ankomstEvent);
			if (state.GetNumberOfCustomers() < state.GetMaxCustomer()) {
				state.IncreaseCustomers();
				double pickTime = state.GetNextPlock(this.tid);
				PlockEvent plockEvent = new PlockEvent(pickTime, this.kund);
				eventQueue.addEvent(plockEvent);
			} else {
				state.IncreaseMissedCustomers();
			}
		}
	}
}
