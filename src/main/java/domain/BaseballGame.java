package domain;

public class BaseballGame {
    Computer computer;

    private void init() {
        computer = new Computer();
    }

    private void playGame() {
        computer.createNumbers();
    }

    public void run() {
        init();
        playGame();
    }
}
