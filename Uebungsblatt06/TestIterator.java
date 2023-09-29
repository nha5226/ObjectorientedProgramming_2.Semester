package Uebungsblatt06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestIterator {

	public static void main(String args[]) {

		List<Integer> list = new ArrayList<Integer>();
		//List<Integer> list+= new LinkedList<Integer>();

		list.add(4);
		list.add(7);
		list.add(9);
		list.add(12);
		list.add(20);

		MyListIterator it = new MyListIterator(list);

		while(it.hasNext()) {
			int x = it.next();

			System.out.println(x);

		}
	}
}
