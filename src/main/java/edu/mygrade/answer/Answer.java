package edu.mygrade.answer;


/*
 * 정답
 *
 */
public class Answer {

	private final int collect;

	public Answer(int collect) {
		this.collect = collect;
	}

	public int getCollect() {
		return collect;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return false;
		}
		if (!(obj instanceof Answer)) {
			return false;
		}
		return ((Answer) obj).getCollect() == this.getCollect();
	}

}
