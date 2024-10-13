import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("push_back")) {
                int pushBackNum = Integer.parseInt(st.nextToken());
                dq.addLast(pushBackNum);
            } else if (str.equals("push_front")) {
                int pushFrontNum = Integer.parseInt(st.nextToken());
                dq.addFirst(pushFrontNum);
            } else if (str.equals("pop_front")) {
                System.out.println(dq.pollFirst());
            } else if (str.equals("pop_back")) {
                System.out.println(dq.pollLast());
            } else if (str.equals("size")) {
                System.out.println(dq.size());
            } else if (str.equals("empty")) {
                int result = dq.isEmpty() ? 1 : 0;
                System.out.println(result);
            } else if (str.equals("front")) {
                System.out.println(dq.peekFirst());
            } else if (str.equals("back")) {
                System.out.println(dq.peekLast());
            }
            
        }
    }
}