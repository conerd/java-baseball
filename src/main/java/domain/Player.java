package domain;

import java.util.List;

public class Player {
    List<Integer> numbers;

    public void makeNumbers(String inputNumbers) {
        for (int i = 0; i < inputNumbers.length(); i++) {
            numbers.add(inputNumbers.charAt(i) - '0');
        }
    }
}
