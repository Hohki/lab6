package lab6.event;

import lab6.state.Kunder;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.tools.Pair;

public class Betalningshändelse extends Event{
	private double tid;
	private Kunder kund;
	public Betalningshändelse(double tid , Kunder kund) {
		super("Betalning", tid, kund);
		this.tid = tid;
		this.kund = kund;
	}

	@Override
	public void effect() {
		state.IncreaseNumberOfPayedCustomers();
		state.DecreaseCustomers();
		//Delete current costumer? Queue times?
		if (state.FreeKassor() > 0) {
            state.IncreaseFreeKassor();
            
        } else {
            double nextPay = this.state.GetNextPay(this.tid);
        	Betalningshändelse betalningshändelse = new Betalningshändelse(nextPay, state.ObjectFirst());				//First in queue goes to pay
            eventQueue.addEvent(betalningshändelse);																	
            state.removeFirst();																						//Decreases queue
            state.notify(this);

        }
		
		if (state.GetStore() == false && state.NumberOfCustomers() == 0)
			Stopphändelse stopphändelse = new Stopphändelse(null, this.time);											//Adds stop to next in queue if store is closed and empty
        	eventQueue.addEvent(stopphändelse);
	}

}
