package view;

public class OutputView {
	public static void printHint(int strikeCount, int ballCount) {
		if (strikeCount > 0) {
			System.out.println(strikeCount + "스트라이크");
		}
		if (ballCount > 0) {
			System.out.println(ballCount + "볼");
		}
		if (strikeCount == 0 && ballCount == 0) {
			System.out.println("낫싱");
		}
	}

	public static void printWinMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}
}
