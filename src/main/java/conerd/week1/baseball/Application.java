package conerd.week1.baseball;

import java.util.Scanner;

public class Application {
    static final int MAX_ARRAY_LENGTH = 3;
    static final int DISABLE_VALUE = -1;
    static final int GAME_RESTART = 1;

    Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Application myApplication = new Application();

        boolean isGameEnded = false;

        while(!isGameEnded) {
            myApplication.startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            int restartButton = myApplication.myScanner.nextInt();
            isGameEnded = (restartButton == GAME_RESTART) ? false : true;
        }
    }

    void startGame() {
        System.out.println("시작");
        int[] resultArray = getRandomArray();
        for(int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            System.out.println(resultArray[i]);
        }

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
            int[] answerArray = getAnswerArray();

            isGotRight = isRightAnswer(answerArray, resultArray);
        }
    }

    int[] getAnswerArray() {
        int answer = myScanner.nextInt();
        int[] answerArray = new int[MAX_ARRAY_LENGTH];

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            int index = MAX_ARRAY_LENGTH - 1 - i;
            answerArray[index] = (int) (answer % 10);
            answer = (int) (answer / 10);
        }

        return answerArray;
    }

    boolean isRightAnswer(int[] answerArray, int[] resultArray) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (answerArray[i] == resultArray[i]) {
                strikeCount += 1;
                answerArray[i] = DISABLE_VALUE;
            } else {
                boolean isDone = false;
                for (int j = 0; j < MAX_ARRAY_LENGTH && !isDone; j++) {
                    if (resultArray[i] == answerArray[j]) {
                        ballCount += 1;
                        answerArray[j] = DISABLE_VALUE;
                        isDone = true;
                    }
                }
            }
        }

        printHint(strikeCount, ballCount);

        return (strikeCount == MAX_ARRAY_LENGTH) ? true : false;
    }

    void printHint(int strikeCount, int ballCount) {
        if (strikeCount == MAX_ARRAY_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            if (strikeCount > 0 && ballCount > 0) {
                System.out.println(strikeCount + " 스트라이크 " + ballCount + " 볼");
            } else if (strikeCount > 0 && ballCount == 0) {
                System.out.println(strikeCount + " 스트라이크");
            } else if (strikeCount == 0 && ballCount > 0) {
                System.out.println(ballCount + " 볼");
            } else {
                System.out.println("낫싱");
            }
        }
    }
}
