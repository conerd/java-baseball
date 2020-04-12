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
			String currentDigit = digits.split("")[i];
			result.add(new Digit(Integer.parseInt(currentDigit)));
		}
		return of(result);
	}

	public int getStrikes(Digits that) {
		int strikeCount = 0;

		for (int i = 0; i < this.digits.size(); i++) {
			Digit current = digits.get(i);
			Digit another = that.digits.get(i);
			if (current.equals(another)) {
				strikeCount++;
			}
		}

		return strikeCount;
	}

	public int getBalls(Digits that) {
		int ballCount = 0;

		for (int i = 0; i < this.digits.size(); i++) {
			Digit current = digits.get(i);
			Digit another = that.digits.get(i);
			if (that.digits.contains(current) && !current.equals(another)) {
				ballCount++;
			}
		}

		return ballCount;
	}
}
