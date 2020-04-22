import java.util.Random;

public class Computer {

    public static int[] Create(){
        Random random  = new Random();
        int numBoundary =0;
        int[] _computerNum = new int[3];

        while(numBoundary<3){
            if(numBoundary==0){
                _computerNum[numBoundary]=random.nextInt(8)+1;
            }
            else{
                _computerNum[numBoundary]=random.nextInt(8)+1;
                if(numBoundary==1 && _computerNum[numBoundary]==_computerNum[numBoundary-1]) continue;
                if(numBoundary==2 && _computerNum[numBoundary]==_computerNum[numBoundary-1] | _computerNum[numBoundary]==_computerNum[numBoundary-2]) continue;
            }
            numBoundary++;
        }
        return _computerNum;
    }

    public static int[] Check(int[] _userNum, int[] _computerNum){
        int _strike =0;
        int _ball = 0;
        int[] _strikeAndBallArry = new int[2];

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (_computerNum[j] == _userNum[k]) {
                    if (j == k) {
                        _strike++;
                    } else {
                        _ball++;
                    }
                    break;
                }
            }
        }

        _strikeAndBallArry[0]=_ball;
        _strikeAndBallArry[1]=_strike;

        return  _strikeAndBallArry;
    }

    public static int numBallAndStrike(int[] _strikeAndBallArry) {
        if (_strikeAndBallArry[0] == 0 && _strikeAndBallArry[1] == 0) {
            System.out.printf("낫싱");
        } else if (_strikeAndBallArry[0] == 0) {
            System.out.printf(_strikeAndBallArry[1] + "스트라이크 ");
        } else if (_strikeAndBallArry[1] == 0) {
            System.out.printf(_strikeAndBallArry[0] + "볼 ");
        } else {
            System.out.printf(_strikeAndBallArry[1] + "스트라이크 " + _strikeAndBallArry[0] + "볼");
        }

        if (_strikeAndBallArry[1] == 3) {
            return _strikeAndBallArry[1];
        }
        return 0;
    }
}
