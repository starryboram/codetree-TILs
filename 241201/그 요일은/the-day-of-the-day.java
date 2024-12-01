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

        for (int i = m1 ; i < m2 ; i++) {
            d2 += monthArr[i];
        }
        
        countDay = d2 - d1;
        System.out.println(calDay(day, countDay));

    }

    public static int calDay(String day, int countDay) {
        int calDate = countDay/7 + 1;
        return day == "Mon" && countDay%7 == 0 ? calDate + 1 : calDate;
    }
}