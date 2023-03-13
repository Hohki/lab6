/**
 * @author Albin
 * @author Khaled
 * @author Gabriel
 * */

package lab6.state;

import java.util.Random;


public class UniformRandomStream {

	private Random rand;
	private double lower, width;

	/**
	 * @param lower, upper seed
	 * @return nothing
	 * */
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.width = upper-lower;
	}

	/**
	 * @param lower, upper
	 * @return nothing
	 * */

	public UniformRandomStream(double lower, double upper) {
		rand = new Random();
	    this.lower = lower;
	    this.width = upper-lower;
	}

	/**
	 * @param nothing
	 * @return lower+rand.nextDouble()*width
	 * */
	
	public double next() {
	    return lower+rand.nextDouble()*width;
	}
}

