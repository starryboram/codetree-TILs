import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine());
            System.out.print(calYear(num));
        } catch (Exception e){
            System.out.print("error");
        }
    }

    private static boolean calYear(int num) {
        if (num%4 == 0) {
            if ((num%100 == 0) && (num%400 != 0)) {
                return false;
                }
            return true;
        }
        return false;
    }
}