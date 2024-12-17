import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arrX;
    static int[] arrY;
    static int OFFSET = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrX = new int[N];
        arrY = new int[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrX[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            arrY[i] = Integer.parseInt(st.nextToken()) + OFFSET;
        }

        int minDist = Integer.MAX_VALUE;
        int exclusiveNum = 1;
        while (exclusiveNum < N) {
            int tempDist = 0;
            int nowX = arrX[0];
            int nowY = arrY[0];
            for(int i=1; i<N; i++) {
                if(exclusiveNum == i) {
                    continue;
                }
                int newX = arrX[i];
                int newY = arrY[i];
                tempDist += (Math.abs(newX - nowX) + Math.abs(newY - nowY));
                nowX = newX;
                nowY = newY;
            }
            minDist = Math.min(minDist, tempDist);
            exclusiveNum++;
        }

        System.out.println(minDist);

    }
}