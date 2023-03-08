package lab6.view;

public class View {
import java.util.Observer;
import lab6.state.State;
import java.util.Observable;

public class View implements Observer {
	protected State state;
	
	public View(State state) {
		this.state = state;
	}
	
	public void update (Observable obj, Object arg) {
		
	}
}
