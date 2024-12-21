import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer input = Integer.parseInt(br.readLine());

        int[] arr = new int[20];
        int cnt = 0;

        while (true) {
            if (input < 2) {
                arr[cnt++] = input;
                break;
            }
            arr[cnt++] = input%2;
            input = input/2;
        }

        for(int i = cnt - 1 ; i >= 0 ; i--) {
            System.out.print(arr[i]);
        }
    }
}