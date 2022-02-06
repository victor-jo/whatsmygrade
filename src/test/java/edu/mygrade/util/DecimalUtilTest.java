package edu.mygrade.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalUtilTest {

	@Test
	@DisplayName("입력된 실수들을 소수점 X번째 짜리까지 반올림하여 표시하여야 한다")
	public void 입력된_실수들을_소수점_X번째_짜리까지_반올림하여_표시하여야_한다() {
		final double value = 2.792037;

		assertEquals(DecimalUtil.round(value, 0), 3);
		assertEquals(DecimalUtil.round(value, 1), 2.8);
		assertEquals(DecimalUtil.round(value, 2), 2.79);
		assertEquals(DecimalUtil.round(value, 3), 2.792);
		assertEquals(DecimalUtil.round(value, 4), 2.7920);
		assertEquals(DecimalUtil.round(value, 5), 2.79204);
		assertEquals(DecimalUtil.round(value, 6), 2.792037);
		assertEquals(DecimalUtil.round(value, 7), 2.792037);
		assertEquals(DecimalUtil.round(value, 8), 2.792037);
	}

}