package lab6.event;

import lab6.state.*;
import lab6.tools.Pair;

public class Ankomsthändelse extends Event {
	private Kunder kund;
	private StoreState state;
	
	
	public Ankomsthändelse(State state, String str, Pair pair, EventQueue queue) {
		super(state, str, pair, queue);
		this.str = str;
		this.pair = pair;
		Event.eventQueue = queue;
	}

	@Override
	public void effect(State state) {
		if (this.state.GetStore()) {
			double nextArrival = this.state.GetNextArrival(pair.tid());
			CustomerFactory kund = new CustomerFactory();
			Kunder newKund = kund.CreateCustomers();
			pair = new Pair(newKund, nextArrival);
			Ankomsthändelse ankomsthändelse = new Ankomsthändelse(state, str, pair, eventQueue);
			Event.eventQueue.addEvent(ankomsthändelse);
			if (this.state.NumberOfCustomers() < this.state.GetMaxCustomer()) {
				this.state.IncreaseCustomers();
				double pickTime = this.state.GetNextPlock(pair.tid());
				Plockhändelse plockhändelse = new Plockhändelse(this.state, this.eventQueue, pickTime, pair.kund());
				Event.eventQueue.addEvent(plockhändelse);
			}
			else {
				this.state.IncreaseMissedCustomers();
			}	
		}
		else {
			
		}
		
	}
	

}
