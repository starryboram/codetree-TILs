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

    public static int function(int num1, int num2) {
        int cnt = 0;
        for (int i = num1 ; i <= num2 ; i++) {
            if (isPrime(i) && numberSumIsEven(i)) cnt += 1;
        }
        return cnt;
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }

    public static boolean numberSumIsEven(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num%10;
            num = num/10;
        }
        return (sum%2 == 0);
    }
}