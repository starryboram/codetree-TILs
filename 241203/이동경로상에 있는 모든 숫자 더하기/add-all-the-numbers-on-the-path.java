import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 행 0:오른쪽, 1:아래쪽, 2: 왼쪽, 3:위쪽
    static int[] dy = {1, 0, -1, 0}; // 열
    static int[] L = {3, 0, 1, 2};
    static int[] R = {1, 2, 3, 0};
    static int N,T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        String[] orders = br.readLine().split("");

        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = moveArr(orders, arr);
        System.out.println(cnt);

    }

    private static int moveArr(String[] orders, int[][] arr) {
        int cnt = 0;
        int dir = 3; // 북쪽
        int x = N/2;
        int y = N/2;
        for(int i=0; i<T; i++) {
            cnt += arr[x][y];

            String order = orders[i];
            dir = chooseDir(dir, order);

            if(!order.equals("F")) {
                continue;
            }
            
            int nx = 0;
            int ny = 0;
            while(true) {
                nx = x + dx[dir];
                ny = y + dy[dir];
                if(inRange(nx ,ny)) {
                    break;
                } else {
                    i++;
                    if(i>=T) {
                        break;
                    }
                }
            }

            x = nx;
            y = ny;
        }

        return cnt;
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }

    private static int chooseDir(int dir, String order) {

        switch (order) {
            case "L": {
                dir = L[dir];
                break;
            }
            case "R": {
                dir = R[dir];
                break;
            }
        }
        return dir;
    }
}