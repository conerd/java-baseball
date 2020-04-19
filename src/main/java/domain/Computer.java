package domain;

import java.util.List;

public class Computer {
    private static final int MAX_LENGTH = 3;
    private static final int RANDOM_RANGE = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    List<Integer> numbers;

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
}
