import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine());
            String result = (num%2 == 0) && checkMultipleOfFive(num) ? "Yes" : "No";
            System.out.print(result);
            
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean checkMultipleOfFive(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num%10;
            num = num/10;
        }
        return sum%5 == 0 ? true : false;
    }
}