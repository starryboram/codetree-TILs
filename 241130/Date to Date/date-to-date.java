import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        Integer a = Integer.parseInt(input[0]);
        Integer b = Integer.parseInt(input[1]);
        Integer c = Integer.parseInt(input[2]);
        Integer d = Integer.parseInt(input[3]);

        int[] intArr = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int countDay = 1;

        while(true) {
            if(a == c && b == d)
                break;
            
            countDay++;
            b++;

            if(b > intArr[a]){
                b = 1;
                a++;
            }
        }    

        System.out.print(countDay);
    
    }
}