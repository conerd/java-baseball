package domain;

import view.InputView;
import view.OutputView;

public class BaseballGame {
	private static final int ALL_MATCH = 3;
	private static final int NO_COUNT = 0;

	public void run() {
		Digits random = new RandomDigitsFactory().create();
		int strikeCount = NO_COUNT;
		int ballCount;

		while (strikeCount != ALL_MATCH) {
			Digits digits = Digits.of(InputView.inputNumbers());

			strikeCount = random.getStrikes(digits);
			ballCount = random.getBalls(digits);

			OutputView.printHint(strikeCount, ballCount);
		}
		OutputView.printWinMessage();
	}
}
