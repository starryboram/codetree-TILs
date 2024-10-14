import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("push_back")) {
                int addNum = Integer.parseInt(st.nextToken());
                list.add(addNum);
            } else if(str.equals("pop_back")) {
                list.remove(list.size() - 1);
            } else if(str.equals("size")) {
                System.out.println(list.size());
            } else if(str.equals("get")) {
                int getNum = Integer.parseInt(st.nextToken());
                System.out.println(list.get(getNum - 1));
            }
        }
    }
}