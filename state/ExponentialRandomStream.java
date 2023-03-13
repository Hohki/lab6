/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import java.util.Random;
/**
 * 
 * Calculates the Ankomst times.
 *
 */
public class ExponentialRandomStream {

	private Random rand;
	private double lambda;

	/**
	 * Constructor for ExpontentialRandomStream.
	 * @param lambda lambda
	 * @param seed seed
	 **/
	public ExponentialRandomStream(double lambda, long seed) {
		rand = new Random(seed);
		this.lambda = lambda;
	}

	/**
	 * Constructor for ExponentialRandomStream.
	 * @param lambda lambda
	 **/

	public ExponentialRandomStream(double lambda) {
		rand = new Random();
		this.lambda = lambda;
	}

	/**
	 * Returns the next random number.
	 * @return -Math.log(rand.nextDouble())/lambda
	 **/

	public double next() {
		return -Math.log(rand.nextDouble()) / lambda;
	}
}
