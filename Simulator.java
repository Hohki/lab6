package lab6;


import lab6.event.EventQueue;
import lab6.event.Event;
import lab6.state.State;

public class Simulator {

	EventQueue queue;
	Event event;
	State state;


	//Constructs and runs the simulation.
	public Simulator(State state) {
		this.state = state;
	}
	
	public void Run () {
		//As long as list is not empty, and simStop is not active, sim will fetch events from list and play its effects.
				while (!state.simStop && !queue.isEmpty()) {
					Event currentEvent = queue.getFirst();
					currentEvent.effect(this.state);
				}
				System.out.print("The simulation is finished");
				
		
	}
	
}

