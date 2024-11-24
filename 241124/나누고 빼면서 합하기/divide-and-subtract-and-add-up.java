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
            m -= 1; // 배열 인덱스 조정
            answer += A[m]; // 먼저 m번째 원소를 더하고, m을 조정합니다.
            if (m % 2 == 0) {
                m /= 2;
            } else {
                m -= 1;
            }
        }
        answer += A[0]; // m이 1이 되었을 때, 수열의 첫 번째 원소를 추가
        return answer;
    }
}
