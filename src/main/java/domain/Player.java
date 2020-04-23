package domain;

import view.InputView;

public class Player {
    Numbers numbers;

    public Numbers makeNumbers(String inputNumbers) {
        this.numbers = new Numbers(InputView.inputNumbers());
        return this.numbers;
    }
}
