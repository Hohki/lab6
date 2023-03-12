package lab6.event;

import lab6.state.*;
import lab6.tools.Pair;

public class Ankomsthändelse extends Event {
	private StoreState state;
	private String str;
	private Pair pair;

	public Ankomsthändelse(String str, Pair pair) {
		super(str, pair);
		this.str = str;
		this.pair = pair;
	}

	@Override
	public void effect() {
		if (state.GetStore()) {
			double nextArrival = state.GetNextArrival(pair.tid());
			CustomerFactory kund = new CustomerFactory();
			Kunder newKund = kund.CreateCustomers();
			pair = new Pair(newKund, nextArrival);
			Ankomsthändelse ankomsthändelse = new Ankomsthändelse(str, pair);
			eventQueue.addEvent(ankomsthändelse);
			if (state.NumberOfCustomers() < state.GetMaxCustomer()) {
				state.IncreaseCustomers();
				double pickTime = state.GetNextPlock(pair.tid());
				Pair nextPlock = new Pair(pair.kund(), pickTime);
				Plockhändelse plockhändelse = new Plockhändelse("Plock", nextPlock);
				eventQueue.addEvent(plockhändelse);
			}
			else {
				state.IncreaseMissedCustomers();
			}	
		}
		else {
			
		}
		
	}
}
