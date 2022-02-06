package edu.mygrade.answer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
	
	@Test
	@DisplayName("정답을 입력하면 입력한 대로 출력되어야 한다")
	public void 정답을_입력하면_입력한_대로_출력되어야_한다() {
		Answer answer = new Answer(3);

		assertEquals(answer.getCollect(), 3);
	}

	@Test
	@DisplayName("정답끼리 비교해 봤을 때 일치하면 Equals 검사가 되어야 한다")
	public void 정답끼리_비교해_봤을_때_일치하면_Equals_검사가_되어야_한다() {
		Answer answer = new Answer(3);

		assertEquals(answer, new Answer(3));
		assertNotEquals(answer, new Answer(5));
		assertNotEquals(answer, new Answer(4));
	}

	@Test
	@DisplayName("자기 자신을 비교했을 때는 틀린 것으로 나와야 한다")
	public void 자기_자신을_비교했을_때는_틀린_것으로_나와야_한다() {
		Answer answer = new Answer(3);

		assertNotEquals(answer, answer);
	}
	
}