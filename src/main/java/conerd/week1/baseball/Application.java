package conerd.week1.baseball;

import java.util.Scanner;

public class Application {
    static final int MAX_ARRAY_LENGTH = 3;
    static final int DISABLE_VALUE = -1;

    public static void main(String[] args) {
        Application myApplication = new Application();

        Scanner myScanner = new Scanner(System.in);

        boolean isGameEnded = false;
        int gameButton = 1;

        while(!isGameEnded) {
            myApplication.startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            gameButton = myScanner.nextInt();
            isGameEnded = (gameButton == 1) ? false : true;
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

            isGotRight = checkAnswer(answerArray, resultArray);
        }
    }

    int[] getAnswerArray() {
        Scanner myScanner = new Scanner(System.in);
        int answer = myScanner.nextInt();
        int[] answerArray = new int[MAX_ARRAY_LENGTH];

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            answerArray[i] = (int) (answer / Math.pow(10, (MAX_ARRAY_LENGTH - 1 - i)));
            answer = (int) (answer % Math.pow(10, (MAX_ARRAY_LENGTH - 1 - i)));
        }

        return answerArray;
    }

    boolean checkAnswer(int[] answerArray, int[] resultArray) {
        boolean isRightAnswer = false;

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

        if (strikeCount == MAX_ARRAY_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isRightAnswer = true;
        } else {
            isRightAnswer = false;
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

        return isRightAnswer;
    }

    int getStrikeCount(int[] answerArray, int[] resultArray) {
        int strikeCount = 0;

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            strikeCount = (answerArray[i] == resultArray[i]) ? strikeCount + 1: strikeCount;
        }

        return strikeCount;
    }
}
