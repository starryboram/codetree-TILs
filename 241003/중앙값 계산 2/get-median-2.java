import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb  = new StringBuilder();
        for(int i=1; i<=n; i++) {
            if(i%2==1) {
                Arrays.sort(arr, 1, i+1);
                int midNum = (1+i)/2;
                sb.append(arr[midNum]).append(" ");
            }
        }

        System.out.println(sb);
    }
}