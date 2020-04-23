package domain;

public class Computer {
    private static final int MAX_LENGTH = 3;

    public int strikeCount = 0;
    public int ballCount = 0;

    Numbers numbers;

    public void createNumbers() {
        this.numbers = new Numbers();
    }

    public void compareNumbers(Numbers playerNumbers) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (numbers.getNumber(i) == playerNumbers.getNumber(i)) {
                strikeCount += 1;
            } else if (playerNumbers.isContaining(numbers.getNumber(i))){
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
}
