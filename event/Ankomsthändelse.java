package lab6.event;

import lab6.state.*;
import lab6.tools.Pair;

public class Ankomsthändelse extends Event {
	private double tid;
	private Kunder kund;

	public Ankomsthändelse(double tid, Kunder kund) {
		super("Ankomst", tid, kund);
		this.tid = tid;
		this.kund = kund;
	}

	@Override
	public void effect() {
		if(state.GetStore()) {
			double nextArrival = state.GetNextArrival(this.tid);
			Kunder newKund = new Kunder(new CustomerFactory().getNumber());
			Ankomsthändelse ankomsthändelse = new Ankomsthändelse(nextArrival, newKund);
			eventQueue.addEvent(ankomsthändelse);
			if (state.NumberOfCustomers() < state.GetMaxCustomer()) {
				state.IncreaseCustomers();
				double pickTime = state.GetNextPlock(this.tid);
				Plockhändelse plockhändelse = new Plockhändelse(pickTime, this.kund);
				eventQueue.addEvent(plockhändelse);
			}
			state.notify(this);
		} else {

		}
	}
}
