package lab6.event;
import lab6.state.Kassakö;
import lab6.state.State;
import lab6.tools.Pair;

public class Plockhändelse extends Event {
	Kassakö kassa = new Kassakö();
	kassa.add();

	 public Plockhändelse(Pair pair) {
		 super("Plock", pair);
	 }

	@Override
	public void effect(State state) {

	}
}
