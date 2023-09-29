package Uebungsblatt06;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyListIterator implements Iterator {

	private List<Integer> data;
	private int index = 0;


	public MyListIterator(List<Integer> data) {
		this.data = data;
	}

	@Override
	public boolean hasNext() {
		return this.index < this.data.size();
	}

	@Override
	public Integer next() {

		while(hasNext() && (data.get(index)) % 2 != 0) {
			index++;
		}

		if(!hasNext()) {
			throw new NoSuchElementException();
		}

		return data.get(index++);
	}
}
