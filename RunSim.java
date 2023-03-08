package lab6;

import lab6.Simulator;
import lab6.event.EventQueue;
import lab6.state.State;
import lab6.state.StoreState;
import lab6.view.View;
import lab6.view.StoreView;


public class RunSim {

	
	public static void main(String[] args) {
		
		
		StoreState shoppingState = new StoreState(//saker);
		StoreView storeView = new StoreView(shoppingState);
		shoppingState.addObserver(storeView);
		Simulator sim = new Simulator(state);
	}
	
}
