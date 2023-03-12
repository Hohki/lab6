package lab6;

import lab6.Simulator;
import lab6.event.EventQueue;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.view.View;
import lab6.view.StoreView;


public class RunSim {
	public static void main(String[] args) {
		StoreState state = new StoreState(2, 5, 24.0, 1.0,
				0.5, 1.0, 2.0, 3.0, 1234);
		StoreView storeView = new StoreView(state);
		Simulator sim = new Simulator(state);
		sim.Run();
	}
	
}
