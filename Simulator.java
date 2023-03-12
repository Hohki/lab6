package lab6;


import lab6.event.EventQueue;
import lab6.event.Event;
import lab6.event.Starthändelse;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.view.View;

public class Simulator {
	private StoreState state;
	Event event;
	private View view;
	//Constructs and runs the simulation.
	public Simulator(StoreState state, View view) {
		this.state = state;
		this.view = view;
		state.addObserver(view);
	}
	
	public void Run () {
		//As long as list is not empty, and simStop is not active, sim will fetch events from list and play its effects.
				Starthändelse starthändelse = new Starthändelse();
				starthändelse.effect();
				while (!state.simStop) {
					Event currentEvent = event.getEventQueue().getFirst();
					currentEvent.effect();
				}
				System.out.print("The simulation is finished");
	}
}

