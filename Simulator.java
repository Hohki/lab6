package lab6;


import lab6.event.Ankomsthändelse;
import lab6.event.Event;
import lab6.event.Starthändelse;
import lab6.state.StoreState;
import lab6.view.View;

public class Simulator {
	private static StoreState state;
	private Event event;
	private View view;
	//Constructs and runs the simulation.
	public Simulator(StoreState state, View view) {
		this.state = state;
		this.view = view;
		state.addObserver(view);
	}
	
	public void Run () {
		//As long as list is not empty, and simStop is not active, sim will fetch events from list and play its effects.
				Event currentEvent = new Starthändelse(0.0);
				for(int i = 0; i < 5; i++) {
					System.out.println(currentEvent.getEventQueue().toString());
					currentEvent.setState(state);
					currentEvent.effect();
					currentEvent.getEventQueue().removeFirstEvent();
					currentEvent.getEventQueue().sortEventQueue();
					currentEvent = currentEvent.getEventQueue().getFirst();
				}
	}
}

