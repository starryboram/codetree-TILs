import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str =  br.readLine().split(" ");
            int num1 = Integer.parseInt(str[0]);
            int num2 = Integer.parseInt(str[1]);
            
            System.out.println(calculateNum(num1, num2));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private static int calculateNum(int a, int b) {
        return (int)Math.pow(a, b);
    }
}