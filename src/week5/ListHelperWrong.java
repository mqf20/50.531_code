package week5;

import java.util.ArrayList;
import java.util.Collections;

public class ListHelperWrong<E> {
	public java.util.List<E> list = Collections.synchronizedList(new ArrayList<E>());

	public synchronized boolean putIfAbsent(E x) {
		boolean absent = !list.contains(x);
		if (absent) {
			list.add(x);
		}
		return absent;
	}
}