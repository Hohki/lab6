/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import java.util.Random;
/**
 * 
 * Calculates Plock and Pay times.
 *
 */
public class UniformRandomStream {

	private Random rand;
	private double lower, width;

	/**
	 * Constructor for UniformRandomStream.
	 * @param lower lower
	 * @param upper upper
	 * @param seed seed
	 */
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.width = upper - lower;
	}

	/**
	 * Constructor for UniformRandomStream.
	 * @param lower lower
	 * @param upper upper
	 */

	public UniformRandomStream(double lower, double upper) {
		rand = new Random();
		this.lower = lower;
		this.width = upper - lower;
	}

	/**
	 * Returns the next calculated number.
	 * @return lower+rand.nextDouble()*width
	 */

	public double next() {
		return lower + rand.nextDouble() * width;
	}
}
