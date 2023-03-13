package lab6.view;

import java.util.Observable;

import lab6.event.Event;
import lab6.event.Stopphändelse;
import lab6.state.*;

public class StoreView extends View {
    StoreState state;

    public StoreView(StoreState state) {
        super(state);
        this.state = state;
        this.state.addObserver(this);
        Parameters();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (this.state.getALlowView()) {
            WriteLine();

/*            if (event instanceof Stopphändelse) {
                EndPrint();
            }*/
        } /*else {
            if (event instanceof Stopphändelse) {
                EndPrint();
            }
        }*/
    }

    public void Parameters() {
        System.out.println("PARAMETRAR");
        System.out.println("==========");
        System.out.println("Antal kassor, N..........: " + state.GetNumberOfKassor());
        System.out.println("Max som ryms, M..........: " + state.GetMaxCustomer());
        System.out.println("Ankomsthastighet, lambda.: " + state.GetLambda());
        System.out.println("Plocktider, [Pmin...Pmax]: [" + state.GetPlockMin() + ".." + state.GetPlockMax());
        System.out.println("Betaltider, [Kmin...Kmax]: [" + state.GetPayMin() + ".." + state.GetPayMax());
        System.out.println("Frö, f...................: " + state.GetSeed());
        System.out.println();
        System.out.println("FÖRLOPP");
        System.out.println("=======");
        System.out.println("Tid Händelse  Kund  ?  led   ledT   I   $   :-(   Köat   KöT  Köar  [Kassakö..]");
    }

    public void WriteLine() {
        System.out.printf("%6.2f %s %s %3d %7.2f % 4d % 4d  % 4d    % 4d  %6.2f    % 4d    %s%n",
                state.CurrentTime(), state.CurrentEvent().eventName(), state.GetStore() ? "Ö" : "S", state.FreeKassor(), state.GetFreeKassorTime(),
                state.GetNumberOfCustomers(), state.NumberOfPayedCustomers(), state.MissedCustomers(), state.NumberOfQueuedCustomers(),
                state.GetQueueTime(), state.CurrentlyQueued().size(), state.GetQueue().toString());
    }

    public void EndPrint() {
        System.out.println("RESULTAT");
        System.out.println("========");
        System.out.println("1) Av " + state.GetNumberOfCustomers() + " handlade " +
                state.NumberOfPayedCustomers() + " medan " + state.MissedCustomers() + " missades.");
        System.out.println("2) Total tid " + state.GetNumberOfKassor() + " kassor varit lediga: " + state.GetFreeKassorTime() + " te.");
        System.out.println("Genomsnittlig ledig kassatid: " + state.GetFreeKassorTime() / state.GetNumberOfKassor() +
                " te (dvs " + (state.GetFreeKassorTime() / state.GetNumberOfKassor()) / state.getLastPay() * 100 +
                "% av tiden från öppning tills sista kunden betalat).");
        System.out.println("3) Total tid " + state.NumberOfQueuedCustomers() + " tvingats köa: " + state.GetQueueTime() + " te.");
        System.out.println("Genomsnittlig kötid: " + state.GetQueueTime() / state.NumberOfQueuedCustomers() + " te.");

    }
}
