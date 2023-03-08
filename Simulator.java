package lab6;

import lab6.event.EventQueue;
import lab6.event.Event;
import lab6.state.State;

public abstract class Simulator {
	
	EventQueue queue;
	Event event;
	State state;
	
	
	//Constructs and runs the simulator.
	public void simulator(State state) {
		
		this.state = state;
		this.queue = new EventQueue();
		
		while (!state.stopSim() && !queue.isEmpty()) {
			
			
		}
		}
	}
	

}
