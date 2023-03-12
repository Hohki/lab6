package lab6;

import lab6.state.StoreState;
import lab6.view.StoreView;

public class OptimizeSim {
    public int sim1(int numberOfKassor, int maxCustomer, double closeTime,
                             double lambda, double pickMin, double pickMax, double payMin, double payMax, long seed) {
        StoreState state = new StoreState(numberOfKassor, maxCustomer, closeTime, lambda, pickMin, pickMax, payMin, payMax,seed, false);
        StoreView storeView = new StoreView(state);
        Simulator sim = new Simulator(state);
        sim.Run();

        return state.MissedCustomers();
    }

    public int sim2(int maxCustomer, double closeTime,
                       double lambda, double pickMin, double pickMax, double payMin, double payMax, long seed) {
        int numberOfKassor = 1;
        int missedCustomers = sim1(numberOfKassor, maxCustomer, closeTime, lambda, pickMin,pickMax,payMin,payMax,seed);
        do {
            if (!(numberOfKassor > maxCustomer)) {
                missedCustomers = sim1(numberOfKassor+1, maxCustomer, closeTime, lambda, pickMin,pickMax,payMin,payMax,seed);
            } else {
                break;
            }
        } while(missedCustomers > 0);

        return numberOfKassor;
    }

    public static void main(String[] args) {
    }
}
