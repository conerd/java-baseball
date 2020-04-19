package domain;

import java.util.ArrayList;

public class Player {
    ArrayList<Integer> numbers;

    public ArrayList<Integer> makeNumbers(String inputNumbers) {
        for (int i = 0; i < inputNumbers.length(); i++) {
            numbers.add(inputNumbers.charAt(i) - '0');
        }

        return numbers;
    }
}
