import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lcm = arr[0];
        for(int i=0; i<n; i++) {
            int baseNum = getGCD(lcm, arr[i]);
            lcm = lcm * arr[i] / baseNum;
        }

        System.out.println(lcm);
    }

    private static int getGCD(int n, int m) {
        if(m==0) return n;
        return getGCD(m, n%m);
    }
}