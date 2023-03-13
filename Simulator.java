/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6;

import lab6.event.*;
import lab6.state.StoreState;
import lab6.view.StoreView;

/**
 * 
 * Skapar starthändelser samt kör alla händelser som därefter dyker upp i
 * eventQueue.
 *
 */
public class Simulator {
	private static StoreState state;

	/**
	 * Konstruktor för Simulator
	 * 
	 * @param state
	 * @param view
	 */
	public Simulator(StoreState state, StoreView view) {
		Simulator.state = state;
	}

	/**
	 * Kör igång hela Simulationen och håller igång det så länge som nödbromsen inte
	 * har aktiverats.
	 */
	public void Run() {
		Event currentEvent = new StartEvent(0.0);

		// Uncomment when code is done
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
				currentEvent = new StoppEvent(state.CurrentTime());
				currentEvent.setState(state);
				state.SetCurrentEvent(currentEvent);
				currentEvent.effect();
			}
		}
	}
}
