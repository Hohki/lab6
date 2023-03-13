/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import java.util.Random;

public class UniformRandomStream {

	private Random rand;
	private double lower, width;

	/**
	 * Konstruktor för UniformRandomStream.
	 * 
	 * @param lower, upper seed
	 */
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.width = upper - lower;
	}

	/**
	 * Konstruktor för UniformRandomStream.
	 * 
	 * @param lower, upper
	 */

	public UniformRandomStream(double lower, double upper) {
		rand = new Random();
		this.lower = lower;
		this.width = upper - lower;
	}

	/**
	 * Returnerar nästa tal.
	 *
	 * @return lower+rand.nextDouble()*width
	 */

	public double next() {
		return lower + rand.nextDouble() * width;
	}
}
