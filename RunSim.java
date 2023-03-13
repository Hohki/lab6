/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6;

import lab6.state.StoreState;
import lab6.view.StoreView;

/**
 * 
 * Starts the simulator
 *
 */

public class RunSim {
	/**
	 * Main method that starts the simulator
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StoreState state = new StoreState(2, 5, 1.0, 0.5, 1.0, 2.0, 3.0, 1234, true, 10.0);
		StoreView storeView = new StoreView(state);
		Simulator sim = new Simulator(state, storeView);
		sim.Run();
	}
}
