package domain;

import java.util.ArrayList;
import java.util.List;

public class Digits {
	private static final int VALID_LENGTH = 3;
	private static final int SELF = 1;

	private final List<Digit> digits;

	private Digits(List<Digit> digits) {
		verify(digits);
		this.digits = digits;
	}

	private void verify(List<Digit> digits) {
		if (digits.size() != VALID_LENGTH) {
			throw new IllegalArgumentException("숫자 야구의 숫자는 3개 이어야 합니다.");
		}
		if (isDuplicated(digits)) {
			throw new IllegalArgumentException("숫자 야구의 숫자는 중복 될 수 없습니다.");
		}
	}

	private boolean isDuplicated(List<Digit> digits) {
		return digits.stream()
			.anyMatch(digit -> hasAnotherEquals(digit, digits));
	}

	private boolean hasAnotherEquals(Digit current, List<Digit> digits) {
		return digits.stream()
			.filter(digit -> digit.equals(current))
			.count() > SELF;
	}

	public static Digits of(List<Digit> digits) {
		return new Digits(digits);
	}

	public static Digits of(String digits) {
		List<Digit> result = new ArrayList<>();

		for (int i = 0; i < VALID_LENGTH; i++) {
			char currentDigit = digits.charAt(i);
			result.add(new Digit(currentDigit));
		}
		return of(result);
	}
}
