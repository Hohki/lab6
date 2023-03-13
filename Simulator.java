package lab6;

import lab6.event.*;
import lab6.state.StoreState;
import lab6.view.StoreView;
import lab6.view.View;

public class Simulator {
	private static StoreState state;
	private Event event;
	private StoreView view;
	public Simulator(StoreState state, StoreView view) {
		this.state = state;
		this.view = view;
	}
	
	public void Run () {
				Event currentEvent = new Starthändelse(0.0);

				//Uncomment when code is done
			while (!state.simStop) {
				if (currentEvent != null) {
					currentEvent.setState(state);
					state.SetCurrentEvent(currentEvent);
					state.SetSimTime(currentEvent.tid());
					System.out.println(currentEvent.toString());
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

