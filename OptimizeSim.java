/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */
package lab6;

import lab6.state.StoreState;
import lab6.view.StoreView;

import java.util.Random;

/**
 * Optimizes the program and outputs the best number of kassor with least missed customers.
 */
public class OptimizeSim {
	/**
	 * Runs Simulator without writing out the stuff in StoreView.
	 * @param numberOfKassor numberOfKassor
	 * @param maxCustomer maxCustomer
	 * @param lambda lambda
	 * @param pickMin pickMin
	 * @param pickMax pickMax
	 * @param payMin payMin
	 * @param payMax payMax
	 * @param seed seed
	 * @param closeTime closeTime
	 * @return missedCustomers missedCustomers
	 */
	public static int sim1(int numberOfKassor, int maxCustomer, double lambda, double pickMin, double pickMax,
			double payMin, double payMax, long seed, double closeTime) {
		StoreState state = new StoreState(numberOfKassor, maxCustomer, lambda, pickMin, pickMax, payMin, payMax, seed,
				false, closeTime);
		StoreView storeView = new StoreView(state);
		Simulator sim = new Simulator(state, storeView);
		sim.Run();

		return state.MissedCustomers();
	}

	/**
	 * Finds the best number of kassor for a specific seed.
	 * @param state state
	 * @return best
	 */
	public static int sim2(StoreState state) {
		int antalKassor = 0;
		int best = 1000;
		int previousMissed = 1000;
		int bestMissed = 0;
		while (antalKassor <= state.GetMaxCustomer()) {
			int missadeCustomers = sim1(antalKassor, state.GetMaxCustomer(), state.GetLambda(), state.GetPlockMin(),
					state.GetPlockMax(), state.GetPayMin(), state.GetPayMax(), state.GetSeed(), state.GetCloseTime());
			if (missadeCustomers < previousMissed) {
				bestMissed = missadeCustomers;
				previousMissed = missadeCustomers;
				best = antalKassor;
			}
			antalKassor++;
		}
		System.out
				.println("Minsta antal kassor som ger minimalt antal missade " + "(" + bestMissed + ")" + ": " + best);
		return best;
	}

	/**
	 * Finds the best number of kassor for different seeds.
	 * @param state state
	 * @return hgstaMinstaAntalet
	 */
	public static int sim3(StoreState state) {
		Random random = new Random(42);
		int antalSim = 0;
		int hgstaMinstaAntalet = 0;
		do {
			int antalKassor = sim2(
					new StoreState(1400, 1400, 100.0, 0.45, 0.65, 0.2, 0.3, random.nextLong(), true, 20.00));
			if (antalKassor > hgstaMinstaAntalet) {
				hgstaMinstaAntalet = antalKassor;
				antalSim = 0;
			} 
			else {
				antalSim++;
			}
		} while (antalSim <= 100);
		return hgstaMinstaAntalet;
	}

	/**
	 * Main method that runs OptimizeSim.
	 * @param args args
	 */
	public static void main(String[] args) {
		StoreState state = new StoreState(K.M, 2, K.L, K.LOW_COLLECTION_TIME, K.HIGH_COLLECTION_TIME, K.LOW_PAYMENT_TIME, K.HIGH_PAYMENT_TIME, K.SEED, true, K.END_TIME);
		System.out.println("Bästa antalet kassor är: " + sim3(state));

	}
}
