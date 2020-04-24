package domain;

public class Computer {
    private static final int MAX_LENGTH = 3;

    private int strikeCount = 0;
    private int ballCount = 0;

    private Numbers numbers;

    public void createNumbers() {
        this.numbers = new Numbers();
    }

    public void compareNumbers(Numbers playerNumbers) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (this.numbers.getNumber(i) == playerNumbers.getNumber(i)) {
                strikeCount += 1;
            } else if (playerNumbers.isContaining(this.numbers.getNumber(i))){
                ballCount += 1;
            }
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isRightAnswer() {
        return (strikeCount == MAX_LENGTH);
    }

    public void reset() {
        strikeCount = 0;
        ballCount = 0;
    }
}
