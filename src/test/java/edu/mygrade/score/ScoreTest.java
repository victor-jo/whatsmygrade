package edu.mygrade.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

	@Test
	@DisplayName("점수는 생성된 그대로 입력되어야 한다")
	public void 점수는_생성된_그대로_입력되어야_한다() {
		Score score = Score.valueOf(30);
		assertEquals(score.getScore(), 30);
	}

}