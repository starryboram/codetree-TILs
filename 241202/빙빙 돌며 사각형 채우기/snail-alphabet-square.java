import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 행 0:오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
    static int[] dy = {1, 0, -1, 0}; // 열
    static int dir = 0;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        fillArr(arr);

        StringBuilder sb = printArr(arr);
        System.out.println(sb);
    }

    private static StringBuilder printArr(char[][] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }

    private static void fillArr(char[][] arr) {
        int x = 0;
        int y = 0;
        int cnt = 1;
        int alphabetBase = 0;
        while (cnt <= n*m) {
            if(alphabetBase > ('Z' - 'A')) {
                alphabetBase = 0;
            }
            arr[x][y] = (char)('A' + alphabetBase++);

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(!inRange(nx, ny) || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;

            cnt++;
        }
    }

    private static boolean inRange(int x, int y) {
        return (0<=x && x<n && 0<=y && y<m);
    }
}