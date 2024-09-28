import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int m = Integer.parseInt(s);
        if(m<=2 || m>=12) {
            System.out.println("Winter");
        } else if(m >= 9) {
            System.out.println("Fall");
        } else if(m >= 6) {
            System.out.println("Summer");
        } else {
            System.out.println("Spring");
        }
    }
}