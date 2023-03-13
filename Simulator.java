package lab6;

import lab6.event.*;
import lab6.state.StoreState;
import lab6.view.StoreView;

public class Simulator {
	private static StoreState state;
	public Simulator(StoreState state, StoreView view) {
		Simulator.state = state;
	}
	
	public void Run () {
				Event currentEvent = new Starthändelse(0.0);

				//Uncomment when code is done
			while (!state.simStop) {
				if (currentEvent != null) {
					currentEvent.setState(state);
					state.SetCurrentEvent(currentEvent);
					state.SetSimTime(currentEvent.tid());
					currentEvent.effect();
					currentEvent.getEventQueue().removeFirstEvent();
					currentEvent.getEventQueue().sortEventQueue();
					currentEvent = currentEvent.getEventQueue().getFirst();
				} else {
					currentEvent = new Stopphändelse(state.CurrentTime());
					currentEvent.setState(state);
					state.SetCurrentEvent(currentEvent);
					currentEvent.effect();
				}
			}
	}
}

