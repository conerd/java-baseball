import domain.Digits;
import view.InputView;

public class BaseballApplication {
	public static void main(String[] args) {
		Digits digits = Digits.of(InputView.inputNumbers());
	}
}
