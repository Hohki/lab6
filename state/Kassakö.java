package lab6.state;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Kassakö {

	private int maxsize = 0;
	private ArrayList<Kunder> queue = new ArrayList<Kunder>();
	
	
	public void add(Kunder arg0) {
		queue.add(arg0);
		if (queue.size() > maxsize) {
			maxsize = maxsize + 1;
		}
	}

	public Kunder first() throws NoSuchElementException {
		try {
			return queue.get(0);
		} catch (Exception e) {
			throw new NoSuchElementException();
		}
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int maxSize() {
		return maxsize;
	}

	public void removeFirst() throws NoSuchElementException {
		try {
			queue.remove(0);
		} catch (Exception e) {
			throw new NoSuchElementException();
		}
		
	}

	public int size() {
		return queue.size();
	}

	@Override
	public String toString() {
		String s = "Queue: ";
		for (int i = 0; i < this.queue.size(); i++) {
			s = s + "(" + String.valueOf(this.queue.get(i).getID()) + ") ";
		}
		return s;
	}
}
