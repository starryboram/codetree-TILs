import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1 ; i <= n ; i++) {
            que.add(i);
        }

        for (int j = 0 ; j < n ; j++) {
            int num = k;
            while (num > 1) {
            que.add(que.poll());
            num--;
            }
        System.out.print(que.peek() + " ");
        que.poll();
        }
    }
}