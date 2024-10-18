import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(fillInSquare(num));
    }

    public static int fillInSquare(int n) {
        int[] arr = new int[n+2];

        arr[1] = 2;
        arr[2] = 7;

        if (n>=3) {
            for (int i = 3 ; i <= n ; i++) {
                arr[i] = (2 * arr[i-1] + 4 * arr[i-2])%1000000007;
            }
        }
        return arr[n];
    }
}