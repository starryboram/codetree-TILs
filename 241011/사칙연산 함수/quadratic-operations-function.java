import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str = br.readLine().split(" ");
            int num1 = Integer.parseInt(str[0]);
            String sign = str[1];
            int num2 = Integer.parseInt(str[2]);

            function(num1, sign, num2);

        } catch (Exception e){
            System.out.println("error");
        }
    }

    private static void function(int num1, String sign, int num2) {
        if(sign.equals("+")) {
            System.out.println(num1 + " " + sign + " " + num2 + " = " + (num1+num2));
        } else if (sign.equals("-")) {
            System.out.println(num1 + " " + sign + " " + num2 + " = " + (num1-num2));
        } else if (sign.equals("/")) {
            System.out.println(num1 + " " + sign + " " + num2 + " = " + (num1/num2));
        } else if (sign.equals("*")) {
            System.out.println(num1 + " " + sign + " " + num2 + " = " + (num1*num2));
        } else {
            System.out.println("False");
        }
    }
}