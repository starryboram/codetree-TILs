import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 1, 0, -1}; // 행: 오른쪽, 아래, 왼쪽, 위 방향
    static int[] dc = {1, 0, -1, 0}; // 열
    static int N,M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[N][N];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = true;

            if(isComfortable(board, r, c)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isComfortable(boolean[][] board, int r, int c) {
        int cnt = 0;
        for(int i=0; i<dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(!isRange(nr, nc)) {
                continue;
            }
            if(board[nr][nc]) {
                cnt++;
            }
        }

        return cnt == 3;
    }

    private static boolean isRange(int nr, int nc) {
        return (0 <= nr && nr < N && 0 <= nc && nc < N);
    }
}