package domain;

import view.InputView;
import view.OutputView;

public class BaseballGame {
    private static final int RESTART = 1;
    private static final int INVALID_VALUE = -1;
    private static final int EXIT = 2;

    Computer computer;
    Player player;

    public void run() {
        init();
        playGame();
    }

    private void init() {
        computer = new Computer();
        player = new Player();
    }

    public void playGame() {
        boolean isGameEnd = false;

        computer.createNumbers();
        while(!isGameEnd) {
            Numbers playerNumbers = player.makeNumbers(InputView.inputNumbers());
            computer.compareNumbers(playerNumbers);

            OutputView.printResult(computer.getStrikeCount(), computer.getBallCount());
            isGameEnd = computer.isRightAnswer();

            computer.reset();
        }
        askRestart();
    }

    private void askRestart() {
        int restartButton = INVALID_VALUE;

        while(restartButton != RESTART && restartButton != EXIT) {
            OutputView.printRestartInfo();
            restartButton = InputView.inputRestart();
        }

        if (restartButton == RESTART) {
            playGame();
        }
    }
}
