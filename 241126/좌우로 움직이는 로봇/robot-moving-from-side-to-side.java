import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int OFFSET = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // A가 움직인 정보
        int m = Integer.parseInt(st.nextToken()); // B가 움직인 정보

        int[] distA = new int[OFFSET + 1]; // t 초 후의 A 의 위치
        int[] distB = new int[OFFSET + 1]; // t 초 후의 B 의 위치
        distA[0] = OFFSET;
        distB[0] = OFFSET;

        move(br, n, distA);
        move(br, m, distB);

        int cnt = count(distA, distB);
        System.out.println(cnt);
    }

    private static int count(int[] distA, int[] distB) {
        int cnt = 0;
        for(int i=1; i<=OFFSET; i++) {
            if((distA[i-1] != distB[i-1]) && (distA[i] == distB[i])) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void move(BufferedReader br, int moveCnt, int[] dist) throws IOException {
        int now = 0;
        StringTokenizer st;
        for(int i = 0; i<moveCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            now = writeHistory(dist, t, direction, now);
        }
        while(++now <= OFFSET) {
            dist[now] = dist[now-1];
        }
    }

    private static int writeHistory(int[] dist, int t, String direction, int now) {
        for(int i=1; i<=t; i++) {
            dist[now + 1] = dist[now++] + (direction.equals("L") ? -1 : 1);
        }
        return now;
    }
}
