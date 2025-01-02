
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static final int SIZE = 19;
    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; // 오른쪽, 오른쪽아래, 아래, 왼쪽아래, 왼쪽, 왼쪽위, 위, 오른쪽위
    static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) {

        int[][] board = new int[SIZE][SIZE];
        boolean[][][] checkBoard = new boolean[SIZE][SIZE][8];

        try {
            board = readBoard();
        } catch (IOException e) {
            System.err.println("입력 오류: " + e.getMessage());
            System.exit(1);
        }

        List<Stone> stones = new ArrayList<>();
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        z: for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                if(board[i][j] == 0) {
                    continue;
                }
                if(checkFiveStones(board, checkBoard, i, j, stones)){
                    ans = board[i][j];
                    // stones 중에 x 혹은 y 를 기준으로 가장 가운데에 있는 바둑알의 x,y 좌표를 내보낸다.
                    Collections.sort(stones);
                    Stone stone = stones.get(stones.size() / 2);
                    int middleStoneX = stone.x + 1;
                    int middleStoneY = stone.y + 1;
                    sb.append(ans).append("\n").append(middleStoneX).append(" ").append(middleStoneY);
                    break z;
                }
            }
        }

        if(ans != 0) {
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }

    public static int[][] readBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[SIZE][SIZE];
        for(int i=0; i<SIZE; i++) {
            String[] s = br.readLine().split("\\s+");
            for(int j=0; j<s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        return board;
    }

    private static boolean checkFiveStones(int[][] board, boolean[][][] checkBoard, int x, int y, List<Stone> stones) {
        // 1 혹은 2 가 있었던 것이므로 같은 값이며 같은 방황인지 체크해야한다.
        // 일단 체크된 바둑알은 stones 리스트에 추가한다.
        for(int i=0; i<dx.length; i++) {
            // 해당 지점을 기준으로 주어진 방향으로 5개의 바둑알이 있는지 체크
            if(checkFiveStonesInARow(board, checkBoard, i, x, y, stones)){
                return true;
            }
        }

        return false;
    }

    private static boolean checkFiveStonesInARow(int[][] board, boolean[][][] checkBoard, int direction, int x, int y, List<Stone> stones) {
        stones.clear();
        stones.add(new Stone(x, y, board[x][y]));

        int cnt = 1;
        int stoneColor = board[x][y];
        int currentX = x;
        int currentY = y;
        while(cnt < 5){
            int nx = currentX + dx[direction];
            int ny = currentY + dy[direction];

            if(!inRange(nx, ny)){
                break;
            }

            if(checkBoard[nx][ny][direction]) {
                break;
            }

            if(stoneColor != board[nx][ny]) {
                break;
            }

            checkBoard[nx][ny][direction] = true;
            stones.add(new Stone(nx, ny, board[nx][ny]));
            currentX = nx;
            currentY = ny;
            cnt++;
        }

        return cnt >= 5;
    }

    private static boolean inRange(int x, int y) {
        return (0<=x && x<SIZE && 0<=y && y<SIZE);
    }

    static class Stone implements Comparable<Stone>{
        int x;
        int y;
        int stoneColor;

        public Stone(int x, int y, int stoneColor) {
            this.x = x;
            this.y = y;
            this.stoneColor = stoneColor;
        }

        @Override
        public int compareTo(Stone o) {
            if(this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }
}
