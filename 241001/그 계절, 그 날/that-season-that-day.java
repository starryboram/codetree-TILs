import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final String SPRING = "Spring";
    private static final String SUMMER = "Summer";
    private static final String FALL = "Fall";
    private static final String WINTER = "Winter";

    // 월별 일수 배열, 윤년 여부에 따라 2월은 수정 가능
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (!isDayExists(Y, M, D)) {
            System.out.println(-1);
        } else {
            getSeason(M);
        }
    }

    // 계절을 출력하는 메서드
    private static void getSeason(int m) {
        if (m == 12 || m <= 2) {
            System.out.println(WINTER);
        } else if (m <= 5) {
            System.out.println(SPRING);
        } else if (m <= 8) {
            System.out.println(SUMMER);
        } else {
            System.out.println(FALL);
        }
    }

    private static boolean isDayExists(int y, int m, int d) {
        if (m < 1 || m > 12) return false;

        if (isLeapYear(y)) {
            DAYS_IN_MONTH[1] = 29;
        } else {
            DAYS_IN_MONTH[1] = 28;
        }

        return d >= 1 && d <= DAYS_IN_MONTH[m - 1];
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }
}