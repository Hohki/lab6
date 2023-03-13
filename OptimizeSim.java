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
 * 
 * Optimerar programmet så att det blir bäst antal kassor med minst antal
 * missade kunder.
 *
 */

public class OptimizeSim {
	/**
	 * Kör Simulator utan att skriva ut utskrifter.
	 * 
	 * @param numberOfKassor
	 * @param maxCustomer
	 * @param lambda
	 * @param pickMin
	 * @param pickMax
	 * @param payMin
	 * @param payMax
	 * @param seed
	 * @param closeTime
	 * @return missedCustomers
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
	 * Hittar bästa antalet kassor för ett specifikt seed.
	 * 
	 * @param state
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
	 * Hittar bästa antalet kassor för olika seed
	 * 
	 * @param state
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
	 * Main metod som kör OptimizeSim.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StoreState state = new StoreState(2, 5, 1.0, 0.5, 1.0, 2.0, 3.0, 1234, true, 10.00);
		StoreState state2 = new StoreState(2, 7, 2.0, 0.5, 1.0, 2.0, 3.0, 1234, true, 10.00);
		System.out.println("Bästa antalet kassor är: " + sim3(state2));

	}
}
