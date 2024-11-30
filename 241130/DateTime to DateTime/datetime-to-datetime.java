import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        Integer a = Integer.parseInt(str[0]);
        Integer b = Integer.parseInt(str[1]);
        Integer c = Integer.parseInt(str[2]);

        if(11 > a && 11 > b && 11 > c) {
            System.out.println(-1);
        } 
        
        int diffDay = a - 11;
        int diffTime = b - 11;
        int diffMin = c - 11;
        
        if(diffMin < 0) {
            diffMin += 60;
            diffTime --;
        }

        if(diffTime < 0) {
            diffTime += 24;
            diffDay --;
        }
        
        System.out.print(diffDay * 24 * 60 + diffTime * 60 + diffMin);
    }
}