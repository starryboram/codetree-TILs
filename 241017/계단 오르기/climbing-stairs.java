import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(step(num));
    }

    public static int step(int n) {
        int arr[] = new int[1000];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= n ; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }
        return arr[n]%10007;
    }
}