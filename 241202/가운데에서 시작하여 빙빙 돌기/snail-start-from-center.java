import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 행: 0:오른쪽 1:아래쪽 2:왼쪽 3:위쪽
    static int[] dy = {1, 0, -1, 0}; // 열
    static int[] dirArr = {0, 3, 2, 1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        fillArr(arr);
        printArr(arr);
    }

    private static void printArr(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void fillArr(int[][] arr) {
        int x = n/2;
        int y = n/2;
        int cnt = 1;
        int dir = 0;
        // 규칙이 1,1,2,2,3,3... 순으로 커진다.
        int len = 1;
        int lenCnt = 1;
        int lenFlag = 2;

        while (cnt <= n*n) {
            arr[x][y] = cnt++;

            if(lenCnt == 0) {
                lenFlag--;
                dir = (dir + 1) % 4;
                if(lenFlag == 0) {
                    len++;
                    lenCnt = len;
                    lenFlag = 2;
                } else {
                    lenCnt = len;
                }
            }

            x = x + dx[dirArr[dir]];
            y = y + dy[dirArr[dir]];

            lenCnt--;
        }
    }
}
