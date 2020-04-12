package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDigitsFactory {
	private static final Random random = new Random();
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int DIGITS_LENGTH = 3;

	public Digits create() {
		List<Digit> result = new ArrayList<>();

		for (int i = 0; i < DIGITS_LENGTH; i++) {
			result.add(new Digit(random.nextInt(MAX_NUMBER) + MIN_NUMBER));
		}

		try {
			return Digits.of(result);
		} catch (IllegalArgumentException e) {
			return create();
		}
	}
}
