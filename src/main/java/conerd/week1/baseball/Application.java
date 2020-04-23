package conerd.week1.baseball;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {
    private final int MAX_ARRAY_LENGTH = 3;
    private final int DISABLE_VALUE = -1;
    private final int GAME_RESTART = 1;
    private final int GAME_END = 2;

    Scanner myScanner = new Scanner(System.in);

    List<Integer> resultList = new ArrayList<Integer>(MAX_ARRAY_LENGTH);
    List<Integer> answerList = new ArrayList<Integer>(MAX_ARRAY_LENGTH);

    public static void main(String[] args) {
        Application myApplication = new Application();

//        boolean isGameEnded = false;
//
//        while(!isGameEnded) {
//            myApplication.startGame();
//
//            isGameEnded = myApplication.isGameEnd();
//        }
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

        return !(restartButton == GAME_RESTART);
    }

    void startGame() {
        setResultList();

        playGame();
    }

    void setResultList() {
        if (!resultList.isEmpty()) {
            resultList.clear();
        }

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            resultList.add((int) (Math.random() * 10));
        }
    }

    void playGame() {
        boolean isGotRight = false;

        while(!isGotRight) {
            setAnswerList();

            isGotRight = isRightAnswer();
        }
    }

    void setAnswerList() {
        if (!answerList.isEmpty()) {
            answerList.clear();
        }

        String answer = myScanner.next();

        for (int index = 0; index < MAX_ARRAY_LENGTH; index++) {
            answerList.add(Character.getNumericValue(answer.charAt(index)));
        }
    }

    boolean isRightAnswer() {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            if (answerList.get(i) == resultList.get(i)) {
                strikeCount += 1;
                answerList.set(i, DISABLE_VALUE);
            } else if (isBall(resultList.get(i))) {
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

        for (int i = 0; i < MAX_ARRAY_LENGTH && !isBall; i++) {
            if (result == answerList.get(i)) {
                answerList.set(i, DISABLE_VALUE);
                isBall = true;
            }
        }

        return isBall;
    }
}
