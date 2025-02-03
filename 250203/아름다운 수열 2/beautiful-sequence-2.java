
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arrA, arrB;
    static int cnt;
    public static void main(String[] args) throws IOException {

        readArr();

        // 1. 수열B 를 가지고 전체적인 수열 완성
        // 수열을 set 에 전부 저장하면 너무 많은 경우의 수가 있어 메모리 부하 발생
        // 따라서 그냥 하나의 아름다운 수열이 완성되면 바로 수열 A 에 있는지 체크
        int[] beautifulArr = new int[M];
        boolean[] checkArr = new boolean[M];
        boolean[] checkDuplicatedBeautifulArr = new boolean[N];
        makeBeautifulArr(0, beautifulArr, checkArr,  checkDuplicatedBeautifulArr);

        System.out.println(cnt);
    }

    // 2. 완성된 '아름다운 수열'로 수열A 에 있는지 체크
    private static void countBeautifulArr(int[] beautifulArr, boolean[] checkDuplicatedBeautifulArr) {
        for(int i=0; i<N-M+1; i++) {
            // i~i+M 까지의 수열
            int[] result = Arrays.copyOfRange(arrA, i, i + M);
            if(checkDuplicatedBeautifulArr[i]) continue;
            if(checkSameArr(result, beautifulArr)) {
                checkDuplicatedBeautifulArr[i] = true;
                cnt++;
            }
        }
    }

    private static boolean checkSameArr(int[] result, int[] beautifulArr) {
        return Arrays.equals(result, beautifulArr);
    }

    private static void makeBeautifulArr(int digit, int[] beautifulArr, boolean[] checkArr, boolean[] checkDuplicatedBeautifulArr) {
        if(digit == M) {
            // 이미 같은 형태의 아름다운 수열이 만들어진 경우 지나쳐야함.
            countBeautifulArr(beautifulArr, checkDuplicatedBeautifulArr);
            return;
        }

        for(int i=0; i<M; i++) {
            if(checkArr[i]) continue;
            checkArr[i] = true;
            beautifulArr[digit] = arrB[i];
            makeBeautifulArr(digit+1, beautifulArr, checkArr, checkDuplicatedBeautifulArr);
            checkArr[i] = false;
        }
    }

    private static void readArr() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arrA = new int[N];
        for(int i=0; i<N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        arrB = new int[M];
        for(int i=0; i<M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
    }
}
