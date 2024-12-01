import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int m1 = Integer.parseInt(strArr[0]);
        int d1 = Integer.parseInt(strArr[1]);
        int m2 = Integer.parseInt(strArr[2]);
        int d2 = Integer.parseInt(strArr[3]);

        String day = br.readLine();
        int[] monthArr = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int countDay = 0;

        if(m1 == m2) {
            countDay = d2 - d1 + 1;
        } else {
            countDay += monthArr[m1] - d1 + d2 + 1;
            for (int i = m1 + 1; i < m2; i++) {
                countDay += monthArr[i];
            }
        }
        System.out.println(calDay(day, countDay));
    }
    
    public static int calDay(String day, int countDay) {
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int startIndex = Arrays.asList(days).indexOf(day);  // 시작 요일의 인덱스
        int answer = (countDay - startIndex) / 7;
        return answer + 1;
    }
}