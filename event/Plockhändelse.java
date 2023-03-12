package lab6.event;
import lab6.state.*;
import lab6.tools.Pair;

public class Plockhändelse extends Event {
	private StoreState state;

	 public Plockhändelse(StoreState state, String str, Pair pair) {
		 super(state, "Plock", pair);
		 this.pair = pair;
		 this.state = state;
	 }

	@Override
	public void effect(State state) {
		if (this.state.FreeKassor() > 0) {
			this.state.DecreaseFreeKassor();
			double nextPay = this.state.GetNextPay(this.pair.tid());
			Pair newPay = new Pair(this.pair.kund(), nextPay);
			Betalningshändelse betalningshändelse = new Betalningshändelse(this.state, "Betal", newPay);
			Event.eventQueue.addEvent(betalningshändelse);
		}
		else {
			this.state.GetQueue().add(pair.kund());
			this.state.IncreaseNumberOfQueuedCustomers();
		}
	}
}
