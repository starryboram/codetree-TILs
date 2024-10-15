import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] intArr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < num ; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        int count = num;
        while(count > 0) {
            for (int i = 0 ; i< count - 1 ; i++) {
                int temp = intArr[i];
                if (intArr[i] > intArr[i+1]) {
                    intArr[i] = intArr[i+1];
                    intArr[i+1] = temp;
                }
            }
            count--;
        }
        
        for (int arr : intArr) {
            System.out.print(arr + " ");
        }
    }
}