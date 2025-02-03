
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arrA, arrB;
    static int cnt;
    static Set<String> uniqueBeautifulSequences = new HashSet<>(); // 이미 확인한 아름다운 수열 저장

    public static void main(String[] args) throws IOException {
        readArr();

        // 정렬된 아름다운 수열을 담기 위한 배열
        int[] beautifulArr = new int[M];
        boolean[] checkArr = new boolean[M];

        // 1. 모든 아름다운 수열 만들고, A 배열에서 찾기
        makeBeautifulArr(0, beautifulArr, checkArr);

        System.out.println(cnt);
    }

    private static void countBeautifulArr(int[] beautifulArr) {
        // 배열을 정렬한 문자열로 변환하여 HashSet에 저장
        String key = getStringKey(beautifulArr);
        if (uniqueBeautifulSequences.contains(key)) return;
        uniqueBeautifulSequences.add(key);

        // 슬라이딩 윈도우 방식으로 arrA에서 beautifulArr와 동일한 부분 수열 찾기
        for (int i = 0; i <= N - M; i++) {
            if (checkSameArr(arrA, i, beautifulArr)) {
                cnt++;
            }
        }
    }

    private static boolean checkSameArr(int[] arrA, int start, int[] beautifulArr) {
        for (int i = 0; i < M; i++) {
            if (arrA[start + i] != beautifulArr[i]) return false;
        }
        return true;
    }

    private static void makeBeautifulArr(int digit, int[] beautifulArr, boolean[] checkArr) {
        if (digit == M) {
            countBeautifulArr(beautifulArr);
            return;
        }

        for (int i = 0; i < M; i++) {
            if (!checkArr[i]) {
                checkArr[i] = true;
                beautifulArr[digit] = arrB[i];
                makeBeautifulArr(digit + 1, beautifulArr, checkArr);
                checkArr[i] = false;
            }
        }
    }

    private static String getStringKey(int[] arr) {
        int[] sortedArr = arr.clone();
        return Arrays.toString(sortedArr);
    }

    private static void readArr() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrA = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
    }
}
