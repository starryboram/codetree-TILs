
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N,M;
    static int[] arrA, arrB;
    public static void main(String[] args) throws IOException {

        readArr();

        // 1. 수열B 를 가지고 전체적인 수열 완성
        int[] beautifulArr = new int[M];
        boolean[] checkArr = new boolean[M];
        Set<List<Integer>> duplicationCheckSet = new HashSet<>();
        makeBeautifulArr(0, beautifulArr, checkArr, duplicationCheckSet);

        // 2. 완성된 '아름다운 수열'로 수열A 에 있는지 체크
        int cnt = countBeautifulArr(duplicationCheckSet);
        System.out.println(cnt);
    }

    private static int countBeautifulArr(Set<List<Integer>> duplicationCheckSet) {
        int cnt = 0;
        for(int i=0; i<N-M+1; i++) {
            // i~i+M 까지의 수열
            int[] result = Arrays.copyOfRange(arrA, i, i + M);
            if(duplicationCheckSet.contains(Arrays.stream(result).boxed().collect(Collectors.toList()))) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void makeBeautifulArr(int digit, int[] beautifulArr, boolean[] checkArr, Set<List<Integer>> duplicationCheckSet) {
        if(digit == M) {
            duplicationCheckSet.add(Arrays.stream(beautifulArr).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i=0; i<M; i++) {
            if(checkArr[i]) continue;
            checkArr[i] = true;
            beautifulArr[digit] = arrB[i];
            makeBeautifulArr(digit+1, beautifulArr, checkArr, duplicationCheckSet);
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
