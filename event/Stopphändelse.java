/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

public class Stopphändelse extends Event{
	double tid;
	/**
	 * Konstruktor för Stopphändelse
	 * @param tid
	 */
	public Stopphändelse(double tid) {
		super("Stopp", tid);
	}
	/**
	 * Aktiverar nödbromsen.
	 */
	@Override
	public void effect() {
		state.notify(this);
		state.stopSim();
	}
	
}
