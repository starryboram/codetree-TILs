import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Set<Integer> set = new HashSet<>();
        for(int num : A) {
            set.add(num);
        }
        
        boolean flag = true;
        for(int num: B) {
            if(!set.contains(num)) {
                flag = false;
                break;
            }
        }
        
        System.out.println(flag ? "Yes" : "No");
    }
}