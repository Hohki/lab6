package lab6;

import lab6.Simulator;
import lab6.event.EventQueue;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.view.View;
import lab6.view.StoreView;


public class RunSim {
	


	
	public static void main(String[] args) {
		
		
		StoreState state = new StoreState(//saker);									//creates state
		EventQueue queue = new EventQueue();										//creates queue
		
		queue.addsomestartthingy();
		queue.addsomeendythingy();
		queue.addsomestopthingy();
				
		StoreView storeView = new StoreView(state);									//creates view
		state.addObserver(storeView);												//creates observer
		Simulator sim = new Simulator(state, queue);								//creates simulator
		sim.Run();
	}
	
}
