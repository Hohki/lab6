/**
 * Albin, Khaled, Gabriel
 * */

package lab6.event;

import lab6.state.Kunder;

public class Betalningshändelse extends Event{
	private double tid;
	public Betalningshändelse(double tid , Kunder kund) {
		super("Betalning", tid, kund);
		this.tid = tid;
	}

	@Override
	public void effect() {
		state.notify(this);
		state.IncreaseNumberOfPayedCustomers();
		state.DecreaseCustomers();
		//Delete current costumer? Queue times?
		if (state.GetQueue().size() == 0) {
            state.IncreaseFreeKassor();
            
        }
		else {
            double nextPay = state.GetNextPay(this.tid);
        	Betalningshändelse betalningshändelse = new Betalningshändelse(nextPay, state.GetQueue().first());				//First in queue goes to pay
            eventQueue.addEvent(betalningshändelse);																	
            state.GetQueue().removeFirst();																					//Decreases queue
        }
	}

}
