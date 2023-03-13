package lab6;

import lab6.state.StoreState;
import lab6.view.StoreView;

import java.util.Random;

public class OptimizeSim {
    public static int sim1(int numberOfKassor, int maxCustomer,
                    double lambda, double pickMin, double pickMax, double payMin, double payMax, long seed) {
        StoreState state = new StoreState(numberOfKassor, maxCustomer, lambda, pickMin, pickMax, payMin, payMax, seed, false);
        StoreView storeView = new StoreView(state);
        Simulator sim = new Simulator(state, storeView);
        sim.Run();

        return state.MissedCustomers();
    }

    public static int sim2(StoreState state) {
        int numberOfKassor = 1;
        int missedCustomers;
        do {
            if (!(numberOfKassor > state.GetMaxCustomer())) {
                missedCustomers = sim1(numberOfKassor + 1, state.GetMaxCustomer(), state.GetLambda(), state.GetPlockMin(), state.GetPlockMax(), state.GetPayMin(), state.GetPayMax(), state.GetSeed());
                numberOfKassor++;
            } else {
                break;
            }
        } while (missedCustomers > 0);

        System.out.println("Minsta antal kassor som ger minimalt antal missade: " + numberOfKassor);
        return numberOfKassor;
    }

    public static int sim3(StoreState state) {
        Random random = new Random(state.GetSeed());
        int antalSim = 0;
        int högstaMinstaAntalet = 0;
        do {
            int antalKassor = sim2(state);
            if (antalKassor > högstaMinstaAntalet) {
                högstaMinstaAntalet = antalKassor;
                antalSim = 0;
            } else {
                antalSim++;
            }
        } while (antalSim <= 100);

        return högstaMinstaAntalet;
    }

    public static void main(String[] args) {
        StoreState state = new StoreState(2, 5,  1.0,
                0.5, 1.0, 2.0, 3.0, 1234, true);
        sim3(state);
    }
}
