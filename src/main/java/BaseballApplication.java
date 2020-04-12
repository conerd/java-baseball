import domain.Digits;
import domain.RandomDigitsFactory;
import view.InputView;
import view.OutputView;

public class BaseballApplication {
	private static final String NEW_GAME = "1";

	public static void main(String[] args) {
		do {
			boolean isNotCorrected = true;
			Digits random = new RandomDigitsFactory().create();

			while (isNotCorrected) {
				Digits digits = Digits.of(InputView.inputNumbers());

				int strikeCount = random.getStrikes(digits);
				int ballCount = random.getBalls(digits);

				OutputView.printHint(strikeCount, ballCount);

				if (strikeCount == 3) {
					isNotCorrected = false;
				}
			}

			OutputView.printWinMessage();
		} while (NEW_GAME.equals(InputView.inputNewOrQuit()));

	}
}
