package lab6.state;

import java.util.Random;

public class Plockhändelser {
	private Random random;
	private double min;
	private double width;
	
	public void PlockTid(double min, double max, long seed) {
		random = new Random(seed);
		this.min = min;
		this.width = max - min;
	}
	
	public double NästaPlockTid() {
		return min + random.nextDouble()*width;
	}
}
