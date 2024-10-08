import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int num = Integer.parseInt(br.readLine());
            sum1toNum(num);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void sum1toNum(int num) {
        int result = 0;
        for (int i = 1; i < num + 1; i++) {
            result += i;
        }
        System.out.println(result / 10);
    }
}