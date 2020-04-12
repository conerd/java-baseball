import domain.BaseballGame;
import view.InputView;

public class BaseballApplication {
	private static final String NEW_GAME = "1";

	public static void main(String[] args) {
		do {
			new BaseballGame().run();
		} while (NEW_GAME.equals(InputView.inputNewOrQuit()));
	}
}
