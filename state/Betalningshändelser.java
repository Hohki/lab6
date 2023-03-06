package lab6.state;

import java.util.Random;

public class Betalningshändelser {
	private Random random;
	private double min;
	private double width;
	
	public void BetalningsTid(double min, double max, long seed) {
		random = new Random(seed);
		this.min = min;
		this.width = max - min;
	}
	
	public double NästaBetalningsTid() {
		return min + random.nextDouble()*width;
	}
}
