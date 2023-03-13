/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;
/**
 * 
 * Class for StoppEvent.
 *
 */
public class StoppEvent extends Event {
	double tid;

	/**
	 * Constructs a stoppEvent at a given time point.
	 *
	 * @param tid Time at which the simulations stops
	 */
	public StoppEvent(double tid) {
		super("Stopp", tid);
	}

	/**
	 * Stops the simulation.
	 */
	@Override
	public void effect() {
		state.notify(this);
		state.stopSim();
	}

}
