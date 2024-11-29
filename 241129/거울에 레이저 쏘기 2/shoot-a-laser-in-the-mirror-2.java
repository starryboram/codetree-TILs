import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 행: 0:오른쪽, 1:아래, 2:왼쪽, 3:위
    static int[] dy = {1, 0, -1, 0}; // 열
    static int[] mirrorLeftTilted = {1, 0, 3, 2}; // 바뀌는 방향. dir -> dir
    static int[] mirrorRightTilted = {3, 2, 1, 0};
    static int[] directionK = {1, 2, 3, 0};
    static int N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<N; j++) {
                arr[i][j] = input[j];
            }
        }

        // 시작 지점 칸 구하기

        K = Integer.parseInt(br.readLine()); // 레이저를 쏘는 위치
        // 0: 아래, 1: 왼, 2:위, 3: 오른
        int dir = directionK[K / N];
        int x, y;

        switch (K / N) {
            case 0: { // 상단
                x = 0;
                y = K % N - 1;
                break;
            }
            case 1:  { // 오른쪽
                x = K % N - 1;
                y = N - 1;
                break;
            }
            case 2:  { // 하단
                x = N - 1;
                y = N - (K % N);
                break;
            }
            case 3:  { // 왼쪽
                x = N - (K % N);
                y = 0;
                break;
            }
            default:  throw new IllegalArgumentException("Invalid direction: " + K / N);
        }

        int cnt = getNumberOfReflections(arr, x, y, dir);

        System.out.println(cnt);
    }

    /**
     * 시뮬레이션(레이저 쏘기): 거울에 팅기는 횟수 구하기
     * 무조건 레이저는 한칸마다 부딪힌다.
     * -> '/' '\' 두개의 벽마다 들어오는 방향에 따른 나가는 방향이 다름
     * @param arr
     * @param x
     * @param y
     * @param dir
     * @return
     */
    private static int getNumberOfReflections(String[][] arr, int x, int y, int dir) {
        int cnt = 1;
        if(Objects.equals(arr[x][y], "/")) { // 오른쪽으로 기운 경우
            dir = mirrorRightTilted[dir];
        } else {
            dir = mirrorLeftTilted[dir];
        }
        int newX = x + dx[dir];
        int newY = y + dy[dir];
        if(inRange(newX, newY)) {
            cnt += getNumberOfReflections(arr, newX, newY, dir);
        }
        return cnt;
    }

    private static boolean inRange(int x, int y) {
        return (0<=x && x<N && 0<=y && y<N);
    }
}