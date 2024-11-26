import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int MAX = 1000 * 1000;
    public static class HallOfFame {
        List<String> list;

        public HallOfFame() {
            this(new ArrayList<>());
        }

        public HallOfFame(List<String> list) {
            this.list = list;
        }

        public void add(String name) {
            list.add(name);
        }

        public boolean isSame(HallOfFame o) {
            if(o == null) {
                return false;
            }
            if(this.list.size() != o.list.size()) {
                return false;
            }
            Collections.sort(this.list);
            Collections.sort(o.list);

            for(int i=0; i<this.list.size(); i++) {
                if(!this.list.get(i).equals(o.list.get(i))){
                    return false;
                }
            }

            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // A
        M = Integer.parseInt(st.nextToken()); // B

        HallOfFame[] hallOfFame = new HallOfFame[MAX]; // 시간 마다의 명예의전당에 기록된 사람
        int[] distA = new int[MAX + 1]; // 시간 마다의 A 가 이동한 총 거리
        int[] distB = new int[MAX + 1]; // 시간 마다의 B 가 이동한 총 거리

        run(br, distA, N);
        run(br, distB, M);

        // 명예의 전당 계산
        for(int i=1; i<MAX; i++) {
            hallOfFame[i] = new HallOfFame();
            if(distA[i] > distB[i]) {
                hallOfFame[i].add("A");
            } else if(distA[i] < distB[i]) {
                hallOfFame[i].add("B");
            } else {
                hallOfFame[i].add("A");
                hallOfFame[i].add("B");
            }
        }

        int cnt = 0;
        for(int i=1; i<MAX; i++) {
            if(!hallOfFame[i].isSame(hallOfFame[i-1])) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void run(BufferedReader br, int[] dist, int moveCnt) throws IOException {
        int now = 0;
        StringTokenizer st;
        for(int i=1; i<=moveCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 속도
            int t = Integer.parseInt(st.nextToken()); // 시간
            for(int j=1; j<=t; j++) {
                dist[now + 1] = dist[now++] + v;
            }
        }

        while (++now < MAX) {
            dist[now] = dist[now-1];
        }
    }
}
