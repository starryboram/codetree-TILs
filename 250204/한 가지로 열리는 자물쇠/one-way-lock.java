
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N,a,b,c;
    public static void main(String[] args) throws IOException {
        // 1~N 까지의 숫자 중에, 3 자리 자물쇠 암호가 주어졌을 때, 자물쇠가 열리게 되는 조합의 수 구하기
        read();

        int totalCnt = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                for(int k=1; k<=N; k++) {
                    if(Math.abs(a - i) > 2  && Math.abs(b - j) > 2 && Math.abs(c - k) > 2) continue;
                    totalCnt++;
                }
            }
        }

        System.out.println(totalCnt);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }
}
