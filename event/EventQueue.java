/**
 *@author Gabriel Axheim Gustafsson
 *@author Khaled Chaaban
 *@author Albin Kullberg
 * */

package lab6.event;

import java.util.ArrayList;

public class EventQueue {
	private ArrayList<Event> eventQueue = new ArrayList<Event>();

	/**
	 * Lägger till event i eventQueue.
	 * 
	 * @param event
	 */
	public void addEvent(Event event) {
		this.eventQueue.add(event);
	}

	/**
	 * Sorterar eventQueue.
	 * 
	 * @param Inget
	 * @return Inget
	 */
	public void sortEventQueue() {
		/*
		 * Sorterar listan efter man har adderat en event så att den första event i
		 * listan är de som kommer att hända tidigast
		 */
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
	 * Tar bort ett event från eventQueue vid ett visst index.
	 * 
	 * @param index
	 * @return tmpEvent
	 */
	public Event removeEvent(int index) {
		Event tmpEvent = this.eventQueue.get(index);
		this.eventQueue.remove(index);
		return tmpEvent;
	}

	/**
	 * Tar bort första eventet i eventQueue.
	 * 
	 * @return tmpEvent
	 */

	public Event removeFirstEvent() {
		Event tmpEvent = this.eventQueue.get(0);
		// System.out.println("First item in list: " +
		// this.eventQueue.get(0).eventName() + this.eventQueue.get(0).tid);
		this.eventQueue.remove(0);
		return tmpEvent;
	}

	/**
	 * Returnerar eventQueue i String form.
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
	 * Kollar om eventQueue är tom eller inte.
	 * 
	 * @return eventQueue.isEmpty();
	 */

	public boolean isEmpty() {
		return this.eventQueue.isEmpty();
	}

	/**
	 * Kollar längden på eventQueue.
	 * 
	 * @return eventQueue.size();
	 */

	public int size() {
		return this.eventQueue.size();
	}

	/**
	 * Returnerar första eventet i eventQueue.
	 * 
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
