import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void setComputerNumbers(int computer[], Random random){
        int i =0;
        while(i<3){
            int x=0;
            if(i==0){
                computer[i]=random.nextInt(8)+1;
            }
            else{
                computer[i]=random.nextInt(8)+1;
                if(i==1 && computer[i]==computer[i-1]) continue;
                if(i==2 && computer[i]==computer[i-1] | computer[i]==computer[i-2]) continue;
            }
            i++;
        }
    }
    public static int checkUserAndComputer(int user[],int computer[], int tmp, int ball, int strike){
        user[0]=tmp/100;
        user[1]=(tmp/10)%10;
        user[2]=tmp%10;

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (computer[j] == user[k]) {
                    if (j == k) strike++;
                    else ball++;
                    break;
                }
            }
        }
        if (strike == 0 && ball == 0)
            System.out.printf("낫싱");
        else if (ball == 0)
            System.out.printf(strike + "스트라이크 ");
        else if (strike == 0)
            System.out.printf(ball + "볼 ");
        else
            System.out.printf(strike + "스트라이크 " + ball + "볼");
        return strike;
    }
    public static void main(String[] args) {
        final int INITIAL_COUNT = 0;
        final int MAX_NUMBER_LENGTH = 3;
        int game = 1;
        while(game==1){

            int computer[] = new int[3];
            int user[] = new int[3];
            int strike = INITIAL_COUNT;
            int ball=INITIAL_COUNT;
            Random random  = new Random();
            Scanner input = new Scanner(System.in);

            setComputerNumbers(computer,random);

            while(strike<3) {
                System.out.printf("\n숫자를 입력해 주세요 : ");
                int tmp = input.nextInt();
                ball = 0;
                strike = 0;

                strike = checkUserAndComputer(user, computer, tmp, ball, strike);
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
