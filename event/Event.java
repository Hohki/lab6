/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import lab6.state.Kunder;
import lab6.state.StoreState;
/**
 * 
 * abstract Event
 *
 */
public abstract class Event {
	protected StoreState state;
	protected static EventQueue eventQueue = new EventQueue();
	private double tid;
	private String str;
	private Kunder kund;

	/**
	 * Konstruktor för Event
	 * 
	 * @param str str
	 * @param tid tid
	 * @param kund kund
	 */
	public Event(String str, double tid, Kunder kund) {
		this.str = str;
		this.tid = tid;
		this.kund = kund;
	}

	/**
	 * Konstruktor för Event
	 * 
	 * @param str str
	 * @param tid tid
	 */

	public Event(String str, double tid) {
		this.str = str;
		this.tid = tid;
	}

	/**
	 * Konstruktor för Event
	 * 
	 * @param str str
	 */

	public Event(String str) {
		this.str = str;
	}

	/**
	 * Konstruktor för Event
	 * 
	 * @param state state
	 */

	public Event(StoreState state) {
		this.state = state;
	}
	/**
	 * Abstract effect
	 */
	public abstract void effect();

	/**
	 * Sätter state till state.
	 * 
	 * @param state state
	 */

	public void setState(StoreState state) {
		this.state = state;
	}

	/**
	 * Getter för state.
	 * 
	 * @return state
	 */

	public StoreState getState() {
		return this.state;
	}

	/**
	 * Getter för namnet på eventet.
	 * 
	 * @return str
	 */
	public String eventName() {
		return this.str;
	}

	/**
	 * Getter för tiden.
	 * 
	 * @return tid
	 */
	public double tid() {
		return this.tid;
	}

	/**
	 * Getter för kunden.
	 * 
	 * @return kund
	 */
	public Kunder kund() {
		return this.kund;
	}

	/**
	 * Getter för eventQueue.
	 * 
	 * @return eventQueue
	 */
	public EventQueue getEventQueue() {
		return eventQueue;
	}

	/**
	 * Getter för str + tid.
	 * 
	 * @return string
	 */
	public String toString() {
		return "(" + this.str + ", " + this.tid + ")";
	}
}