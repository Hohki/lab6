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
	 * @param args args
	 */
	public static void main(String[] args) {
		StoreState state = new StoreState(2, 7, 3.0, 0.6, 0.9, 0.35, 0.6, 13, true, 8.0);
		StoreView storeView = new StoreView(state);
		Simulator sim = new Simulator(state, storeView);
		sim.Run();
	}
}
