/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import lab6.state.*;

public class AnkomstEvent extends Event {
	private double tid;
	private Kunder kund;

	/**
	 * Konstruktor för Ankomsthändelse
	 * 
	 * @param tid
	 * @param kund
	 */

	public AnkomstEvent(double tid, Kunder kund) {
		super("Ankomst", tid, kund);
		this.tid = tid;
		this.kund = kund;
	}

	/**
	 * Kör ankomsteventet. Skapar nästa ankomsthändelse så länge butiken är öppen.
	 * Skapar en plockhändelse om det finns plats för kunden i butiken.
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
