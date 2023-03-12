package lab6;


import lab6.event.EventQueue;
import lab6.event.Event;
import lab6.state.State;
import lab6.view.View;

public class Simulator {
	private State state;
	private View view;
	//Constructs and runs the simulation.
	public Simulator(State state, View view) {
		this.state = state;
		this.view = view;
		state.addObserver(view);
	}
	
	public void Run () {
		//As long as list is not empty, and simStop is not active, sim will fetch events from list and play its effects.
				while (!state.simStop && !state.eventQueue().isEmpty()) {
					Event currentEvent = state.eventQueue().getFirst();
					currentEvent.effect(this.state);
				}
				System.out.print("The simulation is finished");
	}
}

