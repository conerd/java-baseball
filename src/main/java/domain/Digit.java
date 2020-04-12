package domain;

import java.util.Objects;

public class Digit {
	private static final int MAX_NUMBER = 9;
	private static final int MIN_NUMBER = 1;

	private final int digit;

	public Digit(int digit) {
		verify(digit);
		this.digit = digit;
	}

	private void verify(int digit) {
		if (digit > MAX_NUMBER || digit < MIN_NUMBER) {
			throw new IllegalArgumentException("1에서 9이하의 숫자를 입력하세요.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Digit digit1 = (Digit)o;
		return digit == digit1.digit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(digit);
	}
}
