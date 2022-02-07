package edu.mygrade.answer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/*
 * 한 줄 여러 개의 숫자 정답
 *
 */
public class ManyNumberAnswer extends Answer {

	private final Iterator<Integer> iterator;

	public ManyNumberAnswer(List<Integer> collect) {
		this.iterator = new ArrayList<>(collect).iterator();
	}

	@Override
	protected int getCollect() {
		if (!iterator.hasNext()) {
			throw new IndexOutOfBoundsException();
		}
		return iterator.next();
	}

}
