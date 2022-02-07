package edu.mygrade.answer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class AnswerCollectorTest {
	
	@Test
	@DisplayName("입력한 순서대로 정답이 저장되어야 한다")
	public void 입력한_순서대로_정답이_저장되어야_한다() {
		AnswerCollector answerCollector = AnswerCollector.with(10);

		answerCollector.add(AnswerFactory.valueOf(5));
		answerCollector.add(AnswerFactory.valueOf(2));
		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(1));

		Iterator<Answer> iterator = answerCollector.iterator();

		assertEquals(iterator.next(), AnswerFactory.valueOf(5));
		assertEquals(iterator.next(), AnswerFactory.valueOf(2));
		assertEquals(iterator.next(), AnswerFactory.valueOf(3));
		assertEquals(iterator.next(), AnswerFactory.valueOf(1));
	}

	@Test
	@DisplayName("정답과 입력한 정답을 비교가 정상적으로 되어야 한다")
	public void 정답과_입력한_정답을_비교가_정상적으로_되어야_한다() {
		AnswerCollector inputCollector = AnswerCollector.with(10);
		AnswerCollector answerCollector = AnswerCollector.with(10);

		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(2));
		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(2));
		inputCollector.add(AnswerFactory.valueOf(1));
		inputCollector.add(AnswerFactory.valueOf(1));
		inputCollector.add(AnswerFactory.valueOf(4));
		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(3));

		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(1));
		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(2));
		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(1));
		answerCollector.add(AnswerFactory.valueOf(1));
		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(3));

		assertNotEquals(inputCollector, answerCollector);
	}

	@Test
	@DisplayName("정답과 입력한 정답을 비교 후 틀린 갯수를 출력해야 한다")
	public void 정답과_입력한_정답을_비교_후_틀린_갯수를_출력해야_한다() {
		AnswerCollector inputCollector = AnswerCollector.with(10);
		AnswerCollector answerCollector = AnswerCollector.with(10);

		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(2));
		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(2));
		inputCollector.add(AnswerFactory.valueOf(1));
		inputCollector.add(AnswerFactory.valueOf(1));
		inputCollector.add(AnswerFactory.valueOf(4));
		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(3));

		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(1));
		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(2));
		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(1));
		answerCollector.add(AnswerFactory.valueOf(1));
		answerCollector.add(AnswerFactory.valueOf(3));
		answerCollector.add(AnswerFactory.valueOf(3));

		assertEquals(inputCollector.equalsAndGetIncorrectCount(answerCollector), 4);
	}
	
	@Test
	@DisplayName("동일한 정답지나 정답지가 아닌 것과 비교할 경우 IllegalArgumentException 예외가 발생한다")
	public void 동일한_정답지나_정답지가_아닌_것과_비교할_경우_IllegalArgumentException_예외가_발생한다() {
		AnswerCollector inputCollector = AnswerCollector.with(10);

		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(2));
		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(2));
		inputCollector.add(AnswerFactory.valueOf(1));
		inputCollector.add(AnswerFactory.valueOf(1));
		inputCollector.add(AnswerFactory.valueOf(4));
		inputCollector.add(AnswerFactory.valueOf(3));
		inputCollector.add(AnswerFactory.valueOf(3));

		assertThrows(IllegalArgumentException.class, () -> inputCollector.equalsAndGetIncorrectCount(inputCollector));
		assertThrows(IllegalArgumentException.class, () -> inputCollector.equalsAndGetIncorrectCount(AnswerFactory.valueOf(3)));
	}
	
}