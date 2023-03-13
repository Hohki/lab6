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
		System.out.println("En betalning har skett..");
		state.notify(this);
	}

}
