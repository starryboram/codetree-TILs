import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);

        boolean flag = true;
        if(word1.length != word2.length) {
            flag = false;
        } else {
            for(int i=0; i<word1.length; i++) {
                if(word1[i] != word2[i]){
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag?"Yes":"No");

    }
}