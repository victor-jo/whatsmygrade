package edu.mygrade.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCollectorTest {
	
	@Test
	@DisplayName("총합을 입력받고 문제 수를 입력받기 전까지는 문항 점수가 동일해야 한다")
	public void 총합을_입력받고_문제_수를_입력받기_전까지는_문항_점수가_동일해야_한다() {
		ScoreCollector scoreCollector = ScoreCollector.with(Score.valueOf(100));

		assertEquals(scoreCollector.getTotalScore().getScore(), scoreCollector.getAmountScore().getScore());
	}

	@Test
	@DisplayName("총합을 입력받고 문제 수를 입력받으면 문항 점수가 달라져야 한다")
	public void 총합을_입력받고_문제_수를_입력받으면_문항_점수가_달라져야_한다() {
		ScoreCollector scoreCollector = ScoreCollector.with(Score.valueOf(100)).maxProblemCount(35);

		assertNotEquals(scoreCollector.getTotalScore().getScore(), scoreCollector.getAmountScore().getScore());
	}

	@Test
	@DisplayName("총합을 입력받고 문제 수를 입력받으면 문항 점수가 나누어지고 소수점 첫째자리까지 표출한다")
	public void 총합을_입력받고_문제_수를_입력받으면_문항_점수가_나누어지고_소수점_첫째자리까지_표출한다() {
		ScoreCollector scoreCollector = ScoreCollector.with(Score.valueOf(100)).maxProblemCount(35);

		assertEquals(scoreCollector.getAmountScore().getScore(), 2.9);
	}
	
}