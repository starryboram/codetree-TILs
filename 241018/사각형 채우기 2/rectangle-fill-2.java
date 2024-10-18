import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.print(fillInSquare(num));
    }

    public static int fillInSquare(int n) {
        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 3;

        if(n>=3) {
            for(int i = 3 ; i<= n; i++) {
                arr[i] = (arr[i-1] + 2*arr[i-2])%10007;
            }
        }
        return arr[n];
    }
}