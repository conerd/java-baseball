import java.util.Random;

import domain.Digits;
import domain.RandomDigitsFactory;
import view.InputView;

public class BaseballApplication {
	public static void main(String[] args) {
		Digits random = new RandomDigitsFactory().create();
		Digits digits = Digits.of(InputView.inputNumbers());

	}
}
