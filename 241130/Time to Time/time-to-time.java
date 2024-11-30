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
        
        int countTime = 0;
        while(true) {
            if(a == c && b == d)
                break;

            countTime++;
            b++;
            if(b == 60) {
                a++;
                b = 0;
            }
        }

        System.out.print(countTime);
    }
}