import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        int x1 = Integer.parseInt(strArr[0]);
        int x2 = Integer.parseInt(strArr[1]);
        int x3 = Integer.parseInt(strArr[2]);
        int x4 = Integer.parseInt(strArr[3]);

        // 교차 검사
        if (x1 <= x4 && x3 <= x2) {
            System.out.println("intersecting");
        } else {
            System.out.println("nonintersecting");
        }
    }
}