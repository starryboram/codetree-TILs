import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] intArr = new int[2001];
        int place = 1000;

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            String b = arr[1];
            if(b.equals("L")) {
                for (int j = 0 ; j < a ; j++) {
                    intArr[place - j] += 1;
                }
                place -= a;
            } else {
               for (int k = 0 ; k < a; k++) {
                   intArr[place + k] += 1;
               }
                place += a;
            }
        }
        int answer = 0;
        for (int a : intArr) {
            if(a > 1) answer += 1;
        }
        System.out.println(answer);
    }
}