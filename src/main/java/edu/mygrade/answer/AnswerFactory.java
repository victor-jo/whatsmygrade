package edu.mygrade.answer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerFactory {

	private static final String LINE_ANSWER_DELIMITER = " ";

	public static Answer valueOf(int collect) {
		return new NumberAnswer(collect);
	}

	public static Answer valueOf(String lineAnswer) {
		List<Integer> collect = Arrays.stream(lineAnswer.split(LINE_ANSWER_DELIMITER))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		return new ManyNumberAnswer(collect);
	}

}
