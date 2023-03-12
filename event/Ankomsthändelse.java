package lab6.event;

import lab6.state.*;
import lab6.tools.Pair;

public class Ankomsthändelse extends Event {
	private StoreState state;
	
	public Ankomsthändelse(State state, String str, Pair pair) {
		super(state, str, pair);
		this.str = str;
		this.pair = pair;
	}

	@Override
	public void effect(State state) {
		if (this.state.GetStore()) {
			double nextArrival = this.state.GetNextArrival(pair.tid());
			CustomerFactory kund = new CustomerFactory();
			Kunder newKund = kund.CreateCustomers();
			pair = new Pair(newKund, nextArrival);
			Ankomsthändelse ankomsthändelse = new Ankomsthändelse(state, str, pair);
			Event.eventQueue.addEvent(ankomsthändelse);
			if (this.state.NumberOfCustomers() < this.state.GetMaxCustomer()) {
				this.state.IncreaseCustomers();
				double pickTime = this.state.GetNextPlock(pair.tid());
				Pair nextPlock = new Pair(pair.kund(), pickTime);
				Plockhändelse plockhändelse = new Plockhändelse(this.state, "Plock", nextPlock);
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
