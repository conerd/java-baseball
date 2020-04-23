package domain;

public class Player {
    Numbers numbers;

    public Numbers makeNumbers(String inputNumbers) {
        this.numbers = new Numbers(inputNumbers);
        return this.numbers;
    }
}
