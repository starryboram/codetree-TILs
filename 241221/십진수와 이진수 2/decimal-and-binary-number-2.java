import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int num = transferBinaryToDecimel(s);
        transferDecimelToBinary(num * 17);
    }

    public static int transferBinaryToDecimel(String s) {
        int[] binaryArr = new int[s.length()];
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            binaryArr[i] = Integer.parseInt(String.valueOf(c));
        }

        int num = 0;
        for(int a = 0; a < s.length(); a++)
            num = num * 2 + binaryArr[a];
        return num;
    }

    public static void transferDecimelToBinary(int num) {
        int[] intArr = new int[100];
        int cnt = 0;

        while(true) {
            if(num < 2) {
                intArr[cnt++] = num;
                break;
            }
            intArr[cnt++] = num%2;
            num = num/2;
        }

        for(int j = cnt - 1 ; j >= 0 ; j--) {
            System.out.print(intArr[j]);
        }
    }
}