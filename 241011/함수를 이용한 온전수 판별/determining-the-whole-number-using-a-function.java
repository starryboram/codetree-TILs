import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str = br.readLine().split(" ");
            int num1 = Integer.parseInt(str[0]);
            int num2 = Integer.parseInt(str[1]);
            System.out.println(function(num1, num2));

        } catch (Exception e) {
            System.out.println("error");
        }
    }

    private static int function(int num1, int num2) {
        int cnt = 0;
        for(int i = num1; i <= num2 ; i++) {
            cnt += calculateNumber(i);
        }
        return cnt;
    }

    private static int calculateNumber(int i) {
        return !((i%2 == 0) || (i%10 == 5) || ((i%3 == 0) && (i%9 != 0))) ? 1 : 0;
    }
}