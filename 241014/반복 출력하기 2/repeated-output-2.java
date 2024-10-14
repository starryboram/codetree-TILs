import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        printHelloWorld(n);
    }

    public static void printHelloWorld(int num) {
        if(num == 0) return ;

        printHelloWorld(num-1);
        System.out.println("HelloWorld");
    }
}