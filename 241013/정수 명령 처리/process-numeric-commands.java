import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Stack<Integer> stackInt = new Stack<>();

        for (int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("push")) {
                int addNumber = Integer.parseInt(st.nextToken());
                stackInt.add(addNumber); 
            }
            else if (str.equals("size")) {
                System.out.println(stackInt.size());
            } 
            else if (str.equals("empty")) {
                int result = stackInt.isEmpty() ? 1 : 0;
                System.out.println(result);
            }
            else if (str.equals("pop")) {
                System.out.println(stackInt.pop());
            }
            else {
                System.out.println(stackInt.peek());
            }
        }
    }
}