/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import java.util.ArrayList;
/**
 * 
 * Class EventQueue is a class that holds a an arraylist
 * of object Event, used to store all the upcoming events.
 *
 */
public class EventQueue {
	private ArrayList<Event> eventQueue = new ArrayList<Event>();

	/**
	 * Adds an event to the eventQueue.
	 * 
	 * @param event An event has a name and a customer which will do that event.
	 */
	public void addEvent(Event event) {
		this.eventQueue.add(event);
	}

	/**
	 * Sorts the eventQueue so at the begining of the eventQueue is the event
	 * that is going to happen the soonest. Uses an insertionsort to sort the eventQueue.
	 *
	 */
	public void sortEventQueue() {
		if (this.eventQueue.size() > 1) {
			for (int i = 1; i < this.eventQueue.size(); i++) {
				Event tmpEvent = this.eventQueue.get(i);
				int j = i - 1;
				while (j >= 0 && this.eventQueue.get(j).tid() > tmpEvent.tid()) {
					this.eventQueue.set(j + 1, this.eventQueue.get(j));
					j--;
				}
				this.eventQueue.set(j + 1, tmpEvent);
			}
		}
	}

	/**
	 * Removes an event at a given index.
	 *
	 * @param index index of the event to be removed.
	 * @return tmpEvent
	 */
	public Event removeEvent(int index) {
		Event tmpEvent = this.eventQueue.get(index);
		this.eventQueue.remove(index);
		return tmpEvent;
	}

	/**
	 * Removes the first item in the eventQueue.
	 *
	 * @return tmpEvent
	 */

	public Event removeFirstEvent() {
		Event tmpEvent = this.eventQueue.get(0);
		this.eventQueue.remove(0);
		return tmpEvent;
	}

	/**
	 * Returens the eventQueue in string format.
	 * 
	 * @return tmp
	 */
	public String toString() {
		String tmp = "";
		for (int i = 0; i < this.eventQueue.size(); i++) {
			if (this.eventQueue.get(i).kund() != null) {
				tmp = tmp + "(" + this.eventQueue.get(i).eventName() + ", " + "time: " + this.eventQueue.get(i).tid()
						+ ", id:" + this.eventQueue.get(i).kund().getID() + ")" + ", ";
			} else {
				tmp = tmp + "(" + this.eventQueue.get(i).eventName() + ", " + "time: " + this.eventQueue.get(i).tid()
						+ ")" + ", ";
			}
		}
		return tmp;
	}

	/**
	 * Checks if eventQueue is empty of not
	 *
	 * @return eventQueue.isEmpty();
	 */

	public boolean isEmpty() {
		return this.eventQueue.isEmpty();
	}

	/**
	 * Returns the length of the current eventQueue
	 *
	 * @return eventQueue.size();
	 */

	public int size() {
		return this.eventQueue.size();
	}

	/**
	 * Returns first event i eventQueue.
	 * @return event
	 */

	public Event getFirst() {
		if (this.eventQueue.size() > 0) {
			return this.eventQueue.get(0);
		} else {
			return null;
		}
	}
}
