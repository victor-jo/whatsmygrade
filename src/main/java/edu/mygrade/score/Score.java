package edu.mygrade.score;


/*
 * 문제의 점수
 *
 */
public class Score {

	private final double score;

	private Score(double score) {
		this.score = score;
	}

	public static Score valueOf(double score) {
		return new Score(score);
	}

	public double getScore() {
		return score;
	}

}
