package lab6.state;

import java.util.Random;

public class Ankomsthändelser {
	private Random random;
	private double lambda;
	
	public void AnkomstTid(double lambda, long seed) {
		random = new Random(seed);
		this.lambda = lambda;
	}
	
	public double NästaAnkomstTid() {
		return -Math.log(random.nextDouble())/lambda;
	}
}
