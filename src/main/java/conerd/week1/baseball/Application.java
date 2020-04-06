package conerd.week1.baseball;

import java.util.Scanner;

public class Application {
    static final int MAX_ARRAY_LENGTH = 3;

    public static void main(String[] args) {
        Application myApplication = new Application();

        myApplication.startGame();
    }

    void startGame() {
        int[] resultArray = new int[MAX_ARRAY_LENGTH];
        resultArray = getRandomArray();

    }

    int[] getRandomArray() {
        int[] randomArray = new int[MAX_ARRAY_LENGTH];
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            randomArray[i] = (int) (Math.random() * 10);
        }

        return randomArray;
    }

    void playGame() {
        Scanner myScanner = new Scanner(System.in);

        int[] answerArray = new int[MAX_ARRAY_LENGTH];
        int answer = myScanner.nextInt();
        answerArray = getAnswerArray(answer);

    }

    int[] getAnswerArray(int answer) {
        int[] answerArray = new int[MAX_ARRAY_LENGTH];

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            answerArray[i] = (answer / (10 * (MAX_ARRAY_LENGTH - 1 - i)));
            answer = (answer / (10 * (MAX_ARRAY_LENGTH - 1 - i)));
        }

        return answerArray;
    }
}
