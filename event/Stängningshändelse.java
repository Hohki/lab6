/**
 * Albin, Khaled, Gabriel
 * */

package lab6.event;

public class Stängningshändelse extends Event {

	public Stängningshändelse(double tid) {
		super("Stängning", tid);
	}

	@Override
	public void effect() {
		state.notify(this);
		state.SetStoreState(false);
	}

}
