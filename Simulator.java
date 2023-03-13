/**
<<<<<<< Updated upstream
 * @author Albin
 * @author Khaled
 * @author Gabriel
=======
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
>>>>>>> Stashed changes
 * */

package lab6;

import lab6.event.*;
import lab6.state.StoreState;
import lab6.view.StoreView;

public class Simulator {
	private static StoreState state;
	/**
	 * Konstruktor för Simulator
	 * @param state
	 * @param view
	 */
	public Simulator(StoreState state, StoreView view) {
		Simulator.state = state;
	}
	/**
	 * Kör igång hela Simulationen och håller igång det så länge som nödbromsen inte har aktiverats.
	 */
	public void Run () {
				Event currentEvent = new Starthändelse(0.0);

				//Uncomment when code is done
			while (!state.simStop) {
				if (currentEvent != null) {
					currentEvent.setState(state);
					state.SetCurrentEvent(currentEvent);
					state.SetSimTime(currentEvent.tid());
					currentEvent.effect();
					currentEvent.getEventQueue().removeFirstEvent();
					currentEvent.getEventQueue().sortEventQueue();
					currentEvent = currentEvent.getEventQueue().getFirst();
				} else {
					currentEvent = new Stopphändelse(state.CurrentTime());
					currentEvent.setState(state);
					state.SetCurrentEvent(currentEvent);
					currentEvent.effect();
				}
			}
	}
}

