package domain;

import view.InputView;

public class BaseballGame {
    Computer computer;
    Player player;

    private void init() {
        computer = new Computer();
        player = new Player();
    }

    private void playGame() {
        boolean isGameEnd = false;
        computer.createNumbers();
        while(!isGameEnd) {
            player.makeNumbers(InputView.inputNumbers());
        }
    }

    public void run() {
        init();
        playGame();
    }
}
