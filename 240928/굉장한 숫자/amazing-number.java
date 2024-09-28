import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int a = Integer.parseInt(s);
        if((a % 2 == 1 && a%3==0) || (a % 2 == 0 && a%5==0)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}