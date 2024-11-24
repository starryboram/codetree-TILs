import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(function(m, A));
    }

    public static int function(int m, int[] A) {
        int answer = 0;
        while (m > 1) {
            answer += A[m-1];
            if (m % 2 == 0) {
                m /= 2;
            } else {
                m -= 1;
            }
        }
        answer += A[0];
        return answer;
    }
}
