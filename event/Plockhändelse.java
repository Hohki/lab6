package lab6.event;
import lab6.state.Kassakö;
import lab6.state.State;
import lab6.tools.Pair;

public class Plockhändelse extends Event {
	Kassakö kassa = new Kassakö();

	 public Plockhändelse(State state, String str, Pair pair, EventQueue queue) {
		 super(state, "Plock", pair, queue);
	 }

	@Override
	public void effect(State state) {

	}
}
