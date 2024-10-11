import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str = br.readLine().split(" ");
            int num1 = Integer.parseInt(str[0]);
            int num2 = Integer.parseInt(str[1]);
            System.out.println(calculateSum(num1, num2));

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static int calculateSum(int num1, int num2) {
        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            if(isPrime(i)) sum += i;
        }
        return sum;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {  // 제곱근까지만 검사
            if (n % i == 0) return false;          // 나누어 떨어지면 소수가 아님
        }
        return true;
    }
}