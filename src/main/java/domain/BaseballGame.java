package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class BaseballGame {
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
            ArrayList<Integer> playerNumbers = player.makeNumbers(InputView.inputNumbers());
            computer.compareNumbers(playerNumbers);
            OutputView.printResult(computer.getStrikeCount(), computer.getBallCount());
            isGameEnd = computer.isRightAnswer();
        }
    }
}
