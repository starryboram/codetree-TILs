import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            makeRectangle(num1, num2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void makeRectangle(int num1, int num2) {
        for (int i = 0 ; i < num1; i++) {
            StringBuilder sb = new StringBuilder();  // 문자열 빌더를 사용하여 문자열 생성
            for (int j = 0; j < num2; j++) {
                sb.append("1");  // num2 번만큼 "1" 추가
            }
            System.out.println(sb.toString());
        }
    }
}