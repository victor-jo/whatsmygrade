package edu.mygrade.answer;


import java.util.Objects;

/*
 * 숫자 정답
 *
 */
public class NumberAnswer extends Answer {

	private final int collect;

	public NumberAnswer(int collect) {
		this.collect = collect;
	}

	@Override
	protected int getCollect() {
		return collect;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(collect);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return false;
		}
		if (!(obj instanceof NumberAnswer)) {
			return false;
		}
		return ((NumberAnswer) obj).getCollect() == this.getCollect();
	}

}
