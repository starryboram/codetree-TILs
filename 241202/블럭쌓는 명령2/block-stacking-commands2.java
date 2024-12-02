import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        int n = Integer.parseInt(inputStr[0]);
        int m = Integer.parseInt(inputStr[1]);

        int count = m;
        int[] intArr = new int[n + 1];
        while (count > 0) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            if (a != b) {
                for (int j = a; j <= b; j++) {
                    intArr[j] += 1;
                }
            } else {
                intArr[a] += 1;
            }
            count--;
        }
        int answer = Arrays.stream(intArr).max().getAsInt();
        System.out.println(answer > m ? m : answer);
    }
}