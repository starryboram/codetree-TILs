import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K,P,T;

    private static class HandShake implements Comparable<HandShake> {
        int time;
        int x;
        int y;

        public HandShake(int time, int x, int y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(HandShake other) {
            return Integer.compare(this.time, other.time);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        K = Integer.parseInt(st.nextToken()); // 전염 시킬 수 있는 횟수
        P = Integer.parseInt(st.nextToken()); // 최초 감염자
        T = Integer.parseInt(st.nextToken()); // T 번의 악수

        // 초기화
        boolean[] isInfected = new boolean[N+1];
        int[] infectionCountLeft = new int[N+1];
        Arrays.fill(infectionCountLeft, K);
        isInfected[P] = true; // 최초 감염자 세팅

        // 악수 정보 입력
        List<HandShake> handShakes = new ArrayList<>();
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 악수한 시점 (t초)
            int x = Integer.parseInt(st.nextToken()); // 악수할 사람
            int y = Integer.parseInt(st.nextToken()); // 악수할 사람
            handShakes.add(new HandShake(t,x,y));
        }

        // 시간순으로 정렬
        Collections.sort(handShakes);

        // 악수 처리
        for (HandShake handShake : handShakes) {
            processHandShake(handShake, isInfected, infectionCountLeft);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            if(isInfected[i]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
     
        System.out.println(sb);
    }

    // 악수 로직 처리 메서드
    private static void processHandShake(HandShake handShake, boolean[] isInfected, int[] infectionCountLeft) {
        int x = handShake.x;
        int y = handShake.y;

        if (isInfected[x] && !isInfected[y] && infectionCountLeft[x] > 0) {
            isInfected[y] = true;
            infectionCountLeft[x]--;
        } else if (isInfected[y] && !isInfected[x] && infectionCountLeft[y] > 0) {
            isInfected[x] = true;
            infectionCountLeft[y]--;
        } else if (isInfected[x] && isInfected[y]) {
            infectionCountLeft[x] = Math.max(0, infectionCountLeft[x] - 1);
            infectionCountLeft[y] = Math.max(0, infectionCountLeft[y] - 1);
        }
    }
}