import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] intArr = new int[201];
        int count = n;

        while (count > 0) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]) + 100;
            int b = Integer.parseInt(arr[1]) + 100;
            if (a != b) {
                for (int j = a; j <= b; j++) {
                    intArr[j] += 1;
                }
            }
            count--;
        }
        int answer = Arrays.stream(intArr).max().getAsInt();
        System.out.println(answer);
    }
}