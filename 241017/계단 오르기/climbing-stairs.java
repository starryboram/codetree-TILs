import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(step(num));
    }

    public static long step(int n) {
        long arr[] = new long[n+4];
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 1;

        for (int i = 5; i <= n ; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }
        return arr[n]%10007;
    }
}