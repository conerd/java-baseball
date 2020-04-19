package domain;

import java.util.ArrayList;

public class Computer {
    private static final int MAX_LENGTH = 3;
    private static final int RANDOM_RANGE = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public int strikeCount = 0;
    public int ballCount = 0;

    ArrayList<Integer> numbers;

    public void createNumbers() {
        while(numbers.size() != MAX_LENGTH) {
            int number = (int) Math.random() * RANDOM_RANGE;
            if (isValidNumber(number)) {
                numbers.add(number);
            }
        }
    }

    public boolean isValidNumber(int number) {
        return (isInRange(number) && !isDuplicated(number));
    }

    public boolean isInRange(int number) {
        return (MIN_NUMBER <= number && number <= MAX_NUMBER);
    }

    public boolean isDuplicated(int number) {
        return numbers.contains(number);
    }

    public void compareNumbers(ArrayList<Integer> playerNumbers) {
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (numbers.get(i) == playerNumbers.get(i)) {
                strikeCount += 1;
            } else if (playerNumbers.contains(numbers.get(i))){
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
