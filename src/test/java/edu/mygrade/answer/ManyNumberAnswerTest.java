package edu.mygrade.answer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManyNumberAnswerTest {

	@Test
	@DisplayName("빈칸으로 구분된 문자열을 입력하면 순서대로 출력된다")
	public void 빈칸으로_구분된_문자열을_입력하면_순서대로_출력된다() {
		Answer answer = AnswerFactory.valueOf("3 2 1 3 2 1");

		assertEquals(answer.getCollect(), 3);
		assertEquals(answer.getCollect(), 2);
		assertEquals(answer.getCollect(), 1);
		assertEquals(answer.getCollect(), 3);
		assertEquals(answer.getCollect(), 2);
		assertEquals(answer.getCollect(), 1);
	}

	@Test
	@DisplayName("빈칸으로 구분된 문자열을 입력하면 순서대로 출력되다가 리셋 후 가져오면 처음부터 출력된다")
	public void 빈칸으로_구분된_문자열을_입력하면_순서대로_출력되다가_리셋_후_가져오면_처음부터_출력된다() {
		Answer answer = AnswerFactory.valueOf("3 2 1 3 2 1");

		assertEquals(answer.getCollect(), 3);
		assertEquals(answer.getCollect(), 2);
		assertEquals(answer.getCollect(), 1);
		assertEquals(answer.getCollect(), 3);
		assertEquals(answer.getCollect(), 2);
		assertEquals(answer.getCollect(), 1);
	}
	
	@Test
	@DisplayName("입력된 숫자보다 더 많이 정답을 가져오면 IndexOutOfBoundsException 예외처리가 된다")
	public void 입력된_숫자보다_더_많이_정답을_가져오면_IndexOutOfBoundsException_예외처리가_된다() {
		Answer answer = AnswerFactory.valueOf("3 2");

		assertEquals(answer.getCollect(), 3);
		assertEquals(answer.getCollect(), 2);

		assertThrows(IndexOutOfBoundsException.class, answer::getCollect);
	}

}