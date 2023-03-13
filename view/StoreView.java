/**
 * @author Albin
 * @author Khaled
 * @author Gabriel
 * */

package lab6.view;

import java.util.Observable;
import lab6.event.Stopphändelse;
import lab6.event.Stängningshändelse;
import lab6.state.*;
import java.text.DecimalFormat;

public class StoreView extends View {
    StoreState state;
    private DecimalFormat df = new DecimalFormat("0.00");

    public StoreView(StoreState state) {
        super(state);
        this.state = state;
        this.state.addObserver(this);
        Parameters();
    }

    //Observable o är state objected
    //Object arg är själva eventet som ändrade på state objectet
    @Override
    public void update(Observable o, Object arg) {
        if (this.state.getALlowView()) {
            WriteLine();

            if (arg instanceof Stopphändelse) {
                EndPrint();
            }
        } else {
            if (arg instanceof Stopphändelse) {
                System.out.println("Stängning sker tiden " + state.GetCloseTime() + " och stopphändelsen sker tiden " + state.CurrentTime());
            }
        }
    }

    public void Parameters() {
        if (this.state.getALlowView()) {
        System.out.println("PARAMETRAR");
        System.out.println("==========");
        System.out.println("Antal kassor, N..........: " + state.GetNumberOfKassor());
        System.out.println("Max som ryms, M..........: " + state.GetMaxCustomer());
        System.out.println("Ankomsthastighet, lambda.: " + state.GetLambda());
        System.out.println("Plocktider, [Pmin...Pmax]: [" + state.GetPlockMin() + ".." + state.GetPlockMax() + "]") ;
        System.out.println("Betaltider, [Kmin...Kmax]: [" + state.GetPayMin() + ".." + state.GetPayMax() + "]");
        System.out.println("Frö, f...................: " + state.GetSeed());
        System.out.println();
        System.out.println("FÖRLOPP");
        System.out.println("=======");
        System.out.println("   Tid Händelse   Kund   ?  led   ledT   I   $   :-(   Köat   KöT  Köar  [Kassakö..]");
        System.out.println("  0,00 Start");
        } else {
            System.out.println("Max som ryms, M..........: " + state.GetMaxCustomer());
            System.out.println("Ankomsthastighet, lambda.: " + state.GetLambda());
            System.out.println("Plocktider, [Pmin...Pmax]: [" + state.GetPlockMin() + ".." + state.GetPlockMax() + "]") ;
            System.out.println("Betaltider, [Kmin...Kmax]: [" + state.GetPayMin() + ".." + state.GetPayMax() + "]");
            System.out.println("Frö, f...................: " + state.GetSeed());
        }
    }

    public void WriteLine() {
    	if (state.CurrentEvent() instanceof Stängningshändelse) {
    		System.out.printf("%6.2f %-9s %5s %3s %4s % 6.2f % 3d  % 2d  % 4d  %5s % 4.2f %5s %s %n",
                    state.CurrentTime(), state.CurrentEvent().eventName(), "---", state.GetStore() ? "Ö" : "S", state.FreeKassor(), state.GetFreeKassorTime(),
                    state.GetNumberOfCustomers(), state.NumberOfPayedCustomers(), state.MissedCustomers(), state.NumberOfQueuedCustomers(),
                    state.GetQueueTime(), state.CurrentlyQueued().size(), state.GetQueue().toString());
    	}
    	else if (state.CurrentEvent() instanceof Stopphändelse) {
    		System.out.println(" " + df.format(state.CurrentTime()) + " Stop");
    	}
    	else {
    		System.out.printf("%6.2f %-9s %5s %3s %4s % 6.2f % 3d  % 2d  % 4d  %5s % -6.2f %5s %s %n",
                    state.CurrentTime(), state.CurrentEvent().eventName(), state.CurrentEvent().kund().getID(), state.GetStore() ? "Ö" : "S", state.FreeKassor(), state.GetFreeKassorTime(),
                    state.GetNumberOfCustomers(), state.NumberOfPayedCustomers(), state.MissedCustomers(), state.NumberOfQueuedCustomers(),
                    state.GetQueueTime(), state.CurrentlyQueued().size(), state.GetQueue().toString());
    	}
        
    }

    public void EndPrint() {
        System.out.println("RESULTAT");
        System.out.println("========");
        System.out.println("1) Av " + (state.NumberOfPayedCustomers() + state.MissedCustomers()) + " handlade " +
                state.NumberOfPayedCustomers() + " medan " + state.MissedCustomers() + " missades.");
        System.out.println("2) Total tid " + state.GetNumberOfKassor() + " kassor varit lediga: " + df.format(state.GetFreeKassorTime()) + " te.");
        System.out.println("Genomsnittlig ledig kassatid: " + df.format(state.GetFreeKassorTime() / state.GetNumberOfKassor()) +
                " te (dvs " + df.format((state.GetFreeKassorTime() / state.GetNumberOfKassor()) / state.getLastPay() * 100) +
                "% av tiden från öppning tills sista kunden betalat).");
        System.out.println("3) Total tid " + state.NumberOfQueuedCustomers() + " tvingats köa: " + df.format(state.GetQueueTime()) + " te.");
        System.out.println("Genomsnittlig kötid: " + df.format(state.GetQueueTime() / state.NumberOfQueuedCustomers()) + " te.");

    }
}
