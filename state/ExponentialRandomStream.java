/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.state;

import java.util.Random;

public class ExponentialRandomStream {

	private Random rand;
	private double lambda;

	/**
	 * Konstruktor för ExpontentialRandomStream.
	 * 
	 * @param lambda
	 * @param seed
	 * @return Nothing
	 **/
	public ExponentialRandomStream(double lambda, long seed) {
		rand = new Random(seed);
		this.lambda = lambda;
	}

	/**
	 * Konstruktor för ExponentialRandomStream.
	 * 
	 * @param lambda
	 * @return Nothing
	 **/

	public ExponentialRandomStream(double lambda) {
		rand = new Random();
		this.lambda = lambda;
	}

	/**
	 * Returnerar nästa tal.
	 * 
	 * @param Nothing
	 * @return -Math.log(rand.nextDouble())/lambda
	 **/

	public double next() {
		return -Math.log(rand.nextDouble()) / lambda;
	}
}
