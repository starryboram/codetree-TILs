import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] intArr = new int[101];
        int count = n;

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            for (int j = a; j <= b; j++) {
                intArr[j]++;
            }
        }
        int answer = Arrays.stream(intArr).max().getAsInt();
        System.out.println(answer);
    }
}