import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final int Initial_Num = 0;
        final int MAX_NUMBER_LENGTH = 3;
        int game = 1;

        while(game==1){
            int[] computer;
            int[] user;
            int strike = Initial_Num;

            Scanner input = new Scanner(System.in);

            computer = Computer.Create();

            while(strike<MAX_NUMBER_LENGTH) {
                int strikeAndBallArry[] = new int[2];

                System.out.printf("\n숫자를 입력해 주세요 : ");

                user = User.Create();
                strikeAndBallArry = Computer.Check(user,computer);
                strike = Computer.numBallAndStrike(strikeAndBallArry);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            if(input.nextInt()== 2) {
                game = 2;
            } else {
                continue;
            }
        }
    }
}
