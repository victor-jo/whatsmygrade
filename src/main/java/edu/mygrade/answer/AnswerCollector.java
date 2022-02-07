package edu.mygrade.answer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


/*
 * 정답 수집기
 *
 */
public class AnswerCollector implements Iterable<Answer> {

	private final List<Answer> answers;

	private AnswerCollector(int maxProblemCount) {
		answers = new ArrayList<>(maxProblemCount);
	}

	public static AnswerCollector with(int maxProblemCount) {
		return new AnswerCollector(maxProblemCount);
	}

	public void add(Answer answer) {
		this.answers.add(answer);
	}

	public int equalsAndGetIncorrectCount(Object obj) {
		if (obj == this) {
			throw new IllegalArgumentException("동일한 정답을 비교할 수 없습니다.");
		}
		if (!(obj instanceof AnswerCollector)) {
			throw new IllegalArgumentException("정답지가 아닌 것과 비교할 수 없습니다.");
		}
		AnswerCollector target = (AnswerCollector) obj;

		Iterator<Answer> foo = target.iterator();
		Iterator<Answer> bar = this.iterator();

		int incorrectCount = 0;

		while (foo.hasNext() && bar.hasNext()) {
			if (!foo.next().equals(bar.next())) {
				incorrectCount++;
			}
		}

		return incorrectCount;
	}


	@Override
	public int hashCode() {
		return Objects.hashCode(answers);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			throw new IllegalArgumentException("동일한 정답을 비교할 수 없습니다.");
		}
		if (!(obj instanceof AnswerCollector)) {
			throw new IllegalArgumentException("정답지가 아닌 것과 비교할 수 없습니다.");
		}
		AnswerCollector target = (AnswerCollector) obj;

		Iterator<Answer> foo = target.iterator();
		Iterator<Answer> bar = this.iterator();

		while (foo.hasNext() && bar.hasNext()) {
			if (!foo.next().equals(bar.next())) {
				return false;
			}
		}

		return !foo.hasNext() && !bar.hasNext();
	}

	@Override
	public Iterator<Answer> iterator() {
		AtomicInteger index = new AtomicInteger(0);
		return new Iterator<Answer>() {
			@Override
			public boolean hasNext() {
				return index.get() < answers.size();
			}

			@Override
			public Answer next() {
				return answers.get(index.getAndIncrement());
			}
		};
	}

}
