package lab6.event;

import java.util.ArrayList;

public class EventQueue {
    private ArrayList<Event> eventQueue = new ArrayList<Event>();

    public void addEvent(Event event) {
        this.eventQueue.add(event);
        if (this.eventQueue.size() > 1) {
            int j;
            for (int i = 0; i < this.eventQueue.size(); i++) {

                Event tmpEvent = this.eventQueue.get(i);
                j = i + 1;
                while ((j > 0) && this.eventQueue.get(j - 1).tid() < tmpEvent.tid()) {
                    this.eventQueue.set(j, this.eventQueue.get(j - 1));
                    j--;
                }
                this.eventQueue.set(j-1, tmpEvent);
            }
        }
    }

    public void sortEventQueue() {
        /*Sorterar listan efter man har adderat en event
        så att den första event i listan är de som kommer att
        hända tidigast
        * */
        if (this.eventQueue.size() > 1) {
            int j;
            for (int i = 0; i < this.eventQueue.size(); i++) {

                Event tmpEvent = this.eventQueue.get(i);
                j = i + 1;
                while ((j > 0) && this.eventQueue.get(j - 1).tid() < tmpEvent.tid()) {
                    this.eventQueue.set(j, this.eventQueue.get(j - 1));
                    j--;
                }
                this.eventQueue.set(j-1, tmpEvent);
                }
        } else {
            System.out.println("List has no elements or just one element...");
        }
    }

    public Event removeEvent(int index) {
        Event tmpEvent = this.eventQueue.get(index);
        this.eventQueue.remove(index);
        return tmpEvent;
    }

    public Event removeFirstEvent() {
        Event tmpEvent = this.eventQueue.get(0);
        //System.out.println("First item in list: " + this.eventQueue.get(0).eventName() + this.eventQueue.get(0).tid);
        this.eventQueue.remove(0);
        return tmpEvent;
    }

    public String toString() {
        String tmp = "";
        for (int i = 0; i < this.eventQueue.size(); i++) {
            if (this.eventQueue.get(i).kund() != null) {
                tmp = tmp + "(" + this.eventQueue.get(i).eventName() + ", " + "time: " + this.eventQueue.get(i).tid + ", id:" + this.eventQueue.get(i).kund().getID() + ")" + ", ";
            } else {
                tmp = tmp + "(" + this.eventQueue.get(i).eventName() + ", " + "time: " + this.eventQueue.get(i).tid + ")" + ", ";
            }
        }
        return tmp;
    }


    public boolean isEmpty() {
        return this.eventQueue.isEmpty();
    }

    public Event getFirst() {
        return this.eventQueue.get(0);
    }
}
