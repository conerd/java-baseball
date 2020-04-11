package conerd.week1.baseball;

import java.util.Scanner;

public class Application {
    static final int MAX_ARRAY_LENGTH = 3;
    static final int DISABLE_VALUE = -1;
    static final int GAME_RESTART = 1;
    static final int GAME_END = 2;

    Scanner myScanner = new Scanner(System.in);

    int[] resultArray = new int[MAX_ARRAY_LENGTH];
    int[] answerArray = new int[MAX_ARRAY_LENGTH];

    public static void main(String[] args) {
        Application myApplication = new Application();

        boolean isGameEnded = false;

        while(!isGameEnded) {
            myApplication.startGame();

            isGameEnded = myApplication.isGameEnd();
        }
    }

    boolean isGameEnd() {
        int restartButton = DISABLE_VALUE;

        while (restartButton == DISABLE_VALUE) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            restartButton = myScanner.nextInt();

            if (restartButton != GAME_RESTART && restartButton != GAME_END) {
                System.out.println("요청에 맞지 않는 답입니다. 다시 입력하세요.");
                restartButton = DISABLE_VALUE;
            }
        }

        return (restartButton == GAME_RESTART);
    }

    void startGame() {
        resultArray = getRandomArray();

        playGame(resultArray);
    }

    int[] getRandomArray() {
        int[] randomArray = new int[MAX_ARRAY_LENGTH];

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            randomArray[i] = (int) (Math.random() * 10);
        }

        return randomArray;
    }

    void playGame(int[] resultArray) {
        boolean isGotRight = false;

        while(!isGotRight) {
            setAnswerArray();

            isGotRight = isRightAnswer();
        }
    }

    void setAnswerArray() {
        int answer = myScanner.nextInt();

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            int index = MAX_ARRAY_LENGTH - 1 - i;
            answerArray[index] = (int) (answer % 10);
            answer = (int) (answer / 10);
        }
    }

    boolean isRightAnswer() {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (answerArray[i] == resultArray[i]) {
                strikeCount += 1;
                answerArray[i] = DISABLE_VALUE;
            } else if (isBall(resultArray[i])){
                ballCount += 1;
            }
        }

        if (strikeCount == MAX_ARRAY_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            printHint(strikeCount, ballCount);
        }

        return (strikeCount == MAX_ARRAY_LENGTH);
    }

    void printHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else {
            if (strikeCount > 0) {
                System.out.printf("%d 스트라이크 ", strikeCount);
            }
            if (ballCount > 0) {
                System.out.printf("%d 볼", ballCount);
            }
            System.out.println();
        }
    }

    boolean isBall(int result) {
        boolean isBall = false;

        for (int j = 0; j < MAX_ARRAY_LENGTH && !isBall; j++) {
            if (result == answerArray[j]) {
                answerArray[j] = DISABLE_VALUE;
                isBall = true;
            }
        }

        return isBall;
    }
}
