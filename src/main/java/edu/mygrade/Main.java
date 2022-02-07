package edu.mygrade;

import edu.mygrade.answer.Answer;
import edu.mygrade.answer.AnswerCollector;
import edu.mygrade.score.Score;
import edu.mygrade.score.ScoreCollector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int maxProblemCount = Integer.parseInt(br.readLine());

		// 제출 정답
		AnswerCollector inputAnswers = new AnswerCollector(maxProblemCount);
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = maxProblemCount;
			while (index-- > 0) {
				inputAnswers.add(new Answer(Integer.parseInt(st.nextToken())));
			}
		}

		// 답안지
		AnswerCollector answers = new AnswerCollector(maxProblemCount);
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = maxProblemCount;
			while (index-- > 0) {
				answers.add(new Answer(Integer.parseInt(st.nextToken())));
			}
		}

		// 총 점수
		final double totalScore = 100;
		ScoreCollector scoreCollector = ScoreCollector.with(Score.valueOf(totalScore)).maxProblemCount(maxProblemCount);

		int incorrectCount = inputAnswers.equalsAndGetIncorrectCount(answers);
		double expectScore = totalScore - (scoreCollector.getAmountScore().getScore() * incorrectCount);

		System.out.println("expectScore = " + expectScore);
		System.out.println("incorrectCount = " + incorrectCount);
	}

}
