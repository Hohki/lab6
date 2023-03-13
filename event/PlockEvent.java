/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import lab6.state.*;

public class PlockEvent extends Event {
	private double tid;
	private Kunder kund;

	/**
	 * Constructer for a plockEvent object, that holds a time
	 * and a customer.
	 *
	 * @param tid Time at which the event will occur.
	 * @param kund Customer that does the event at given time.
	 */
	public PlockEvent(double tid, Kunder kund) {
		super("Plock", tid, kund);
		this.tid = tid;
		this.kund = kund;
	}

	/**
	 * Creates a betalningsEvent for a customer if there is empty space in cashiers. Else adds
	 * customer to a kassaQueue.
	 */
	@Override
	public void effect() {
		state.notify(this);
		if (state.FreeKassor() > 0) {
			state.DecreaseFreeKassor();
			double nextPay = this.state.GetNextPay(this.tid);
			BetalningsEvent betalningsEvent = new BetalningsEvent(nextPay, this.kund);
			eventQueue.addEvent(betalningsEvent);
		} else {
			state.GetQueue().add(this.kund);
			state.IncreaseNumberOfQueuedCustomers();
		}
	}
}
