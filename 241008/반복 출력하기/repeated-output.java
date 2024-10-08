import java.io.*;

public class Main {
    public static void main(String[] args) {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine());
            printNLines(num);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void printNLines(int num) {
        for (int i = 0 ; i < num; i++) {
            System.out.println("12345^&*()_");
        }
    }
}