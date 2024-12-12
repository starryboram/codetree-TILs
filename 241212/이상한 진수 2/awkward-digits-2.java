import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] number = br.readLine().toCharArray();
        int N = Integer.MIN_VALUE;

        // 한자리씩 값을 바꿔가며 N 의 최댓값을 찾는다.
        // 0 만 주어지는 경우엔 하나를 1로 바꿔야 하기 때문에 전체 케이스를 구해야한다.
        for(int i=0; i<number.length; i++) {
            changeNum(number, i);
            // 이진수의 값을 실제값으로 바꾸기
            N = Math.max(N, getNumber(number));

            changeNum(number, i); // 원복
        }
        System.out.println(N);
    }

    public static int getNumber(char[] number) {
        int x = 1;
        int n = 0;
        for(int i=number.length-1; i>=0; i--) {
            n += (Character.getNumericValue(number[i]) * x);
            x *= 2;
        }
        return n;
    }

    public static void changeNum(char[] number, int place) {
        char n = number[place];
        if(n == '0') {
            number[place] = '1';
        } else {
            number[place] = '0';
        }
    }
}