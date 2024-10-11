import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] inputs = br.readLine().split(" ");
            int num1 = Integer.parseInt(inputs[0]);
            int num2 = Integer.parseInt(inputs[1]);
            System.out.print(countNumber(num1, num2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static int countNumber(int num1, int num2) {
        int sum = 0;
        for (int i = num1; i < num2 + 1 ; i++) {
            if(i%3 == 0 || isContains369(i)) sum += 1;
        }
        return sum;
    }

    public static boolean isContains369(int num) {
        while (num > 0) {
            if((num%10 == 3) || (num%10 == 6) || (num%10 == 9)) {
                return true;
            } else {
                num = num/10;
            }
        }
        return false;
    }
}