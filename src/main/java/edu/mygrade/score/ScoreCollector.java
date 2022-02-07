package edu.mygrade.score;


import edu.mygrade.util.DecimalUtil;

/*
 * 각 문항별 점수에 대한 예측을 담당
 *
 */
public class ScoreCollector {

	// 총합
	private Score totalScore;

	// 문항별 점수
	private Score amountScore;

	// 소수점 올림 자리
	private final int DECIMAL_POINT = 1;

	public static ScoreCollector with(Score totalScore) {
		return new ScoreCollector(totalScore);
	}

	private ScoreCollector(Score totalScore) {
		this.totalScore = totalScore;
		this.amountScore = totalScore;
	}

	public Score getTotalScore() {
		return totalScore;
	}

	public Score getAmountScore() {
		return amountScore;
	}

	public ScoreCollector maxProblemCount(int maxProblemCount) {
		this.amountScore = Score.valueOf(DecimalUtil.round(this.totalScore.getScore() / maxProblemCount, DECIMAL_POINT));
		return this;
	}

}
