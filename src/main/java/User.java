import java.util.Scanner;

public class User {

    public static int[] Create(){
        Scanner input = new Scanner(System.in);
        int[] _userNum = new int[3];
        int tmp = input.nextInt();

        _userNum[0]=tmp/100;
        _userNum[1]=(tmp/10)%10;
        _userNum[2]=tmp%10;

        return _userNum;
    }
}
