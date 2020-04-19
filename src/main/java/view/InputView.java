package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_LENGTH = 3;

    public static String inputNumbers() {
        String input = "";

        System.out.printf("숫자를 입력해주세요 : ");
        input = scanner.nextLine();

        while (input.length() != MAX_LENGTH) {
            System.out.println("3자리 숫자를 입력해주세요: ");
            input = scanner.nextLine();
        }

        return input;
    }
}
