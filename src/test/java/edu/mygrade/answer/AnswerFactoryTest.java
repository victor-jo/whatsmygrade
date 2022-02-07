package edu.mygrade.answer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerFactoryTest {
	
	@Test
	@DisplayName("정수를 넣으면 NumberAnswer 클래스가 생성되어야 한다")
	public void 정수를_넣으면_NumberAnswer_클래스가_생성되어야_한다() {
		Answer answer = AnswerFactory.valueOf(3);
		
		assertTrue(answer instanceof NumberAnswer);
	}
	
	@Test
	@DisplayName("빈칸으로 구분된 문자열을 넣으면 ManyNumberAnswer 클래스가 생성되어야 한다")
	public void 빈칸으로_구분된_문자열을_넣으면_ManyNumberAnswer_클래스가_생성되어야_한다() {
		Answer answer = AnswerFactory.valueOf("3 3 2 1 3");

		assertTrue(answer instanceof ManyNumberAnswer);
	}

}