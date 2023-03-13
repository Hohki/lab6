/**
 * Albin, Khaled, Gabriel
 * */

package lab6;


import lab6.state.StoreState;
import lab6.view.StoreView;


public class RunSim {
	public static void main(String[] args) {
		StoreState state = new StoreState(2, 5, 1.0,
				0.5, 1.0, 2.0, 3.0, 1234, true, 10.0);
		StoreView storeView = new StoreView(state);
		Simulator sim = new Simulator(state, storeView);
		sim.Run();
	}
}
