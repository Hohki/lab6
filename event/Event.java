/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import lab6.state.Kunder;
import lab6.state.StoreState;
/**
 * An abstract Event class that other classes inherit and implement the
 * effect method, which runs everytime an event is called upon.
 */
public abstract class Event {
	protected StoreState state;
	protected static EventQueue eventQueue = new EventQueue();
	private double tid;
	private String str;
	private Kunder kund;

	/**
	 * Constructs an Event with different types of parameters, as some Events are only
	 * an object without a time.
	 * @param str The name of the Event.
	 * @param tid At what time point the event is going to occur.
	 * @param kund The customer that the event will happen to.
	 */
	public Event(String str, double tid, Kunder kund) {
		this.str = str;
		this.tid = tid;
		this.kund = kund;
	}

	/**
	 * Another constructer for Event.
	 * 
	 * @param str The name of the Event.
	 * @param tid At what time point the event is going to occur.
	 */

	public Event(String str, double tid) {
		this.str = str;
		this.tid = tid;
	}

	/**
	 * Another constructer for Event.
	 * 
	 * @param str The name of the Event.
	 */

	public Event(String str) {
		this.str = str;
	}

	/**
	 * Another constructer for Event.
	 * 
	 * @param state A constructer that takes in the state of the store.
	 */

	public Event(StoreState state) {
		this.state = state;
	}
	/**
	 * Abstract method to be implemented by every child of Event.
	 */
	public abstract void effect();

	/**
	 * Sets the events current state to the state provided.*
	 * @param state The state of the store at a given point of time
	 */

	public void setState(StoreState state) {
		this.state = state;
	}

	/**
	 * A getter for state
	 * 
	 * @return state
	 */

	public StoreState getState() {
		return this.state;
	}

	/**
	 * Getter for the name of the event.
	 * 
	 * @return str
	 */
	public String eventName() {
		return this.str;
	}

	/**
	 * Getter for the time of the event.
	 * 
	 * @return tid
	 */
	public double tid() {
		return this.tid;
	}

	/**
	 * Getter for the customer that is going to do the event.
	 * 
	 * @return kund
	 */
	public Kunder kund() {
		return this.kund;
	}

	/**
	 * Getter for the eventQueue that holds all of the events that are going
	 * to occur.
	 * 
	 * @return eventQueue
	 */
	public EventQueue getEventQueue() {
		return eventQueue;
	}

	/**
	 * Gives the event in string format as a pair, name of the event and the time at
	 * which it will happen at.
	 * 
	 * @return string
	 */
	public String toString() {
		return "(" + this.str + ", " + this.tid + ")";
	}
}