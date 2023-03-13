/**
 * @author Albin
 * @author Khaled
 * @author Gabriel
 * */

package lab6.state;

import java.util.Random;

public class ExponentialRandomStream {
	
	private Random rand;
	private double lambda;
	/**
	 * @param lambda
	 * @param seed
	 * @return Nothing
	 **/
	public ExponentialRandomStream(double lambda, long seed) {
	  	rand = new Random(seed);
	  	this.lambda = lambda;
	}

	/**
	 * @param lambda
	 * @return Nothing
	 **/
	  
	public ExponentialRandomStream(double lambda) {
		rand = new Random();
	    this.lambda = lambda;
	}

	/**
	 * @param Nothing
	 * @return -Math.log(rand.nextDouble())/lambda
	 **/
	  
	public double next() {
	  	return -Math.log(rand.nextDouble())/lambda;
	}
}

