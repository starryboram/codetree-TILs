import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);

        chooseNumPick(num1, num2);
    }

    public static void chooseNumPick(int n1, int n2) {
        int a = Math.min(n1, n2);
        int b = Math.max(n1, n2);

        for (int i = 1 ; i <= a ; i++) {
            for (int j = 1; j <= b; j++) {
                System.out.println(i + " " + j);
            }
        }
    }
}