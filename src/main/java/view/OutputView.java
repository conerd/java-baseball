package view;

public class OutputView {
    private static final int MAX_LENGTH = 3;

    public static void printResult(int strikeCount, int ballCount) {
        if (strikeCount == MAX_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            printHint(strikeCount, ballCount);
        }
    }

    public static void printHint(int strikeCount, int ballCount) {
        if (strikeCount != 0) {
            System.out.printf("%d 스트라이크 ", strikeCount);
        }

        if (ballCount != 0) {
            System.out.printf("%d 볼 ", ballCount);
        }
    }

    public static void printRestartInfo() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
