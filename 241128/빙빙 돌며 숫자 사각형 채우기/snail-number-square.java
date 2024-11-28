
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {0, 1, 0, -1}; // 행
    static final int[] dy = {1, 0, -1, 0}; // 열
    static int dirNum = 0; // 0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        int nowX = 0;
        int nowY = 0;
        int cnt = 1;

        arr[nowX][nowY] = cnt++;
        while(true) {
            int newX = nowX + dx[dirNum];
            int newY = nowY + dy[dirNum];
            if(!inRange(newX, newY) || arr[newX][newY] != 0) {
                dirNum = (dirNum + 1) % 4;
            }

            nowX = nowX + dx[dirNum];
            nowY = nowY + dy[dirNum];

            if(!inRange(nowX, nowY) || arr[nowX][nowY] != 0) {
                break;
            } else {
                arr[nowX][nowY] = cnt++;
            }
        }

        // 출력
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int x, int y) {
        return (0<= x && x<N && 0<=y && y<M);
    }
}