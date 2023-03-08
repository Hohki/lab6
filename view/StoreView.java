package lab6.view;

import lab6.state.*;

public class StoreView extends View {
	StoreState state;
	
	public StoreView(StoreState state) {
		super(state);
		this.state = state;
		parameters();
	}
		
		public void parameters() {
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
			System.out.println("0,00 Start");
	}
		
		public void WriteLine(Object event) {
			System.out.println(String.format
			("%6.2f %s  %s  %3d %7.2f % 4d % 4d  % 4d    % 4d  %6.2f    % 4d    %s",
			 state.CurrentTime(), event.toString(), state.GetStore() ? "Ö" : "S", state.FreeKassor()));
			System.out.print(state.CurrentTime() + " ");
			System.out.printf("'%-10s' %n", event);
			System.out.print();
		}
}
