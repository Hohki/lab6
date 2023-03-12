package lab6.event;

import java.util.ArrayList;

public class EventQueue {
    private ArrayList<Event> eventQueue = new ArrayList<Event>();

    public void addEvent(Event event) {
        this.eventQueue.add(event);
    }

    public void sortEventQueue() {
        /*Sorterar listan efter man har adderat en event
        så att den första event i listan är de som kommer att
        hända tidigast
        * */
        int j;
        for (int i = 0; i < this.eventQueue.size(); i++) {
            Event tmpEvent = this.eventQueue.get(i);
            j = i;
            do {
                this.eventQueue.set(j, this.eventQueue.get(j-1));
                j--;
            } while ((j > 0) && this.eventQueue.get(j-1).tid() > tmpEvent.tid());
            this.eventQueue.set(j, tmpEvent);
        }
    }

    public Event removeEvent(int index) {
        Event tmpEvent = this.eventQueue.get(index);
        this.eventQueue.remove(index);
        return tmpEvent;
    }

    public Event removeFirstEvent() {
        Event tmpEvent = this.eventQueue.get(0);
        this.eventQueue.remove(0);
        return tmpEvent;
    }

    public boolean isEmpty() {
        return this.eventQueue.isEmpty();
    }

    public Event getFirst() {
        return this.eventQueue.get(0);
    }
}
