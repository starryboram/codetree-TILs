
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int[] dx = {0, 1, 0, -1}; // 행: 0:오른쪽, 1:아래, 2:왼쪽, 3:위쪽
    static int[] dy = {1, 0, -1, 0}; // 열
    static int[] dir = {1, 0, 3, 2}; // 순서
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        fillArr(arr);

        StringBuilder sb = new StringBuilder();
        printArr(sb, arr);
        System.out.println(sb);
    }

    private static void printArr(StringBuilder sb, int[][] arr) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void fillArr(int[][] arr) {
        int x = 0;
        int y = 0;
        int cnt = 1;
        int nowDir = 0;
        while (cnt <= n*m) {
            arr[x][y] = cnt++;
            int nx = x + dx[dir[nowDir]];
            int ny = y + dy[dir[nowDir]];
            if(!inRange(nx, ny) || arr[nx][ny] != 0) {
                nowDir =  (nowDir + 1) % 4;
                nx = x + dx[dir[nowDir]];
                ny = y + dy[dir[nowDir]];
            }
            x = nx;
            y = ny;
        }
    }

    private static boolean inRange(int x, int y) {
        return (0<=x && x<n && 0<=y && y<m);
    }
}