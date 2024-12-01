import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // n과 m읽기
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //n개의 원소 읽기
        int[] elements = new int[n+1];
        elements[0] = 0;
        line = br.readLine();
        st = new StringTokenizer(line);
        for (int i = 1 ; i < n + 1 ; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }

        // m개의 쌍 a1, a2 읽기
        for (int i = 0 ; i < m ; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            System.out.println(sumInteger(a1, a2, elements));
        }
    }

    public static int sumInteger(int a1, int a2, int[] elements) {
        int answer = 0;
        for (int j = a1 ; j <= a2 ; j++) {
            answer += elements[j];
        }
        return answer;
    }
}