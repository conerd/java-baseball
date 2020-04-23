package domain;

import java.util.ArrayList;

public class Numbers {
    private static final int MAX_LENGTH = 3;
    private static final int RANDOM_RANGE = 10;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private ArrayList<Integer> numbers;

    public Numbers(String inputNumbers) {
        this.numbers = convertStringToIntegers((inputNumbers));
    }

    public Numbers() {
        this.numbers = createNumbers();
    }

    public ArrayList<Integer> convertStringToIntegers(String inputNumbers) {
        for (int i = 0; i < inputNumbers.length(); i++) {
            this.numbers.add(inputNumbers.charAt(i) - '0');
        }

        return this.numbers;
    }

    public ArrayList<Integer> createNumbers() {
        while(this.numbers.size() != MAX_LENGTH) {
            int number = (int) (Math.random() * RANDOM_RANGE);
            if (isValidNumber(number)) {
                numbers.add(number);
            }
        }
        return this.numbers;
    }

    public boolean isValidNumber(int number) {
        return (isInRange(number) && !isDuplicated(number));
    }

    public boolean isInRange(int number) {
        return (MIN_NUMBER <= number && number <= MAX_NUMBER);
    }

    public boolean isDuplicated(int number) {
        return this.numbers.contains(number);
    }

    public int getNumber(int index) {
        return this.numbers.get(index);
    }

    public boolean isContaining(int number) {
        return this.numbers.contains(number);
    }
}
