import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        printArr(sb, arr);
        Arrays.sort(arr, Collections.reverseOrder());
        printArr(sb, arr);
        System.out.println(sb);
    }

    private static void printArr(StringBuilder sb, Integer[] arr) {
        for(int num : arr) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }
}