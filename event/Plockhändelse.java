/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import lab6.state.*;

public class Plockhändelse extends Event {
	private double tid;
	private Kunder kund;

	/**
	 * Konstruktor för Plockhändelse.
	 * 
	 * @param tid
	 * @param kund
	 */
	public Plockhändelse(double tid, Kunder kund) {
		super("Plock", tid, kund);
		this.tid = tid;
		this.kund = kund;
	}

	/**
	 * Gör en betalningshändelse för en kund om det finns lediga kassor. Lägger
	 * annars till kunden i kassakön.
	 */
	@Override
	public void effect() {
		state.notify(this);
		if (state.FreeKassor() > 0) {
			state.DecreaseFreeKassor();
			double nextPay = this.state.GetNextPay(this.tid);
			Betalningshändelse betalningshändelse = new Betalningshändelse(nextPay, this.kund);
			eventQueue.addEvent(betalningshändelse);
		} else {
			state.GetQueue().add(this.kund);
			state.IncreaseNumberOfQueuedCustomers();
		}
	}
}
