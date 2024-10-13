import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(isCorrectParren(str));
    }

    public static String isCorrectParren(String str) {
        Stack<String> intStack = new Stack<>();
        for (int i = 0 ; i<str.length(); i++) {
            char c = str.charAt(i);
            if (intStack.isEmpty()) {
                if(c == '(') {
                    intStack.push("(");
                } else {
                    return "No";
                }
            } else {
                if(c == '(') {
                    intStack.push("(");
                } else {
                    intStack.pop();
                }
            }
        }

        return (intStack.isEmpty()) ? "Yes" : "No";
    }
}