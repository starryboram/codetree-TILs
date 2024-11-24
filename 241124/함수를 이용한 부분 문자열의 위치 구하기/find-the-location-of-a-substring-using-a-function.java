import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        String targetString = br.readLine();
        System.out.println(inputString.indexOf(targetString));  
    }
}