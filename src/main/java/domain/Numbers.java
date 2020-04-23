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
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length(); i++) {
            numbers.add(inputNumbers.charAt(i) - '0');
        }

        return numbers;
    }

    public ArrayList<Integer> createNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        while(numbers.size() != MAX_LENGTH) {
            int number = (int) (Math.random() * RANDOM_RANGE);
            if (isValidNumber(number, numbers)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    private boolean isValidNumber(int number, ArrayList<Integer> numbers) {
        return (isInRange(number) && !isDuplicated(number, numbers));
    }

    private boolean isInRange(int number) {
        return (MIN_NUMBER <= number && number <= MAX_NUMBER);
    }

    private boolean isDuplicated(int number, ArrayList<Integer> numbers) {
        return numbers.contains(number);
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }

    public boolean isContaining(int number) {
        return numbers.contains(number);
    }
}
