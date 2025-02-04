
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int a1,b1,c1;
    private static int a2,b2,c2;

    public static void main(String[] args) throws IOException {
        read();

        // 1. 3단 조합 구하기
        int cnt = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                for(int k=1; k<=N; k++) {
                    // 2. 주어진 2개의 조합 차이가 2 나는지 확인
                    if(unlock(i, j, k)) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    private static boolean unlock(int i, int j, int k) {
        // 1. 첫번째 조합과 대조
        if(
                (Math.abs(a1 - i) <= 2 || Math.abs(a1 - i) >= N - 2) &&
                        (Math.abs(b1 - j) <= 2 || Math.abs(b1 - j) >= N - 2) &&
                        (Math.abs(c1 - k) <= 2 || Math.abs(c1 - k) >= N - 2)
        ) {
            return true;
        }

        // 2. 두번째 조합과 대조
        else if(
                (Math.abs(a2 - i) <= 2 || Math.abs(a2 - i) >= N - 2) &&
                        (Math.abs(b2 - j) <= 2 || Math.abs(b2 - j) >= N - 2) &&
                        (Math.abs(c2 - k) <= 2 || Math.abs(c2 - k) >= N - 2)
        ) {
            return true;
        }
        return false;
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
    }
}
