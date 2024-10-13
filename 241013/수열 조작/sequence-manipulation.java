import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1 ; i < num; i++ ){
            dq.addLast(i);
        }

        while (dq.size() > 1) {
            dq.pollFirst();
            int dqNum = dq.pollLast();
            dq.addLast(dqNum);
        }
        System.out.println(dq.peekFirst());
    }
}