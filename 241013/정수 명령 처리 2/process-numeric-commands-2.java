import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("push")) {
                int addNumber = Integer.parseInt(st.nextToken());
                que.add(addNumber); 
            }
            else if (str.equals("size")) {
                System.out.println(que.size());
            } 
            else if (str.equals("empty")) {
                int result = que.isEmpty() ? 1 : 0;
                System.out.println(result);
            }
            else if (str.equals("pop")) {
                System.out.println(que.poll());
            }
            else {
                System.out.println(que.peek());
            }
        }
    }
}