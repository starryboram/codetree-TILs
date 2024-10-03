import java.io.*;
import java.util.*;

public class Main {
    static class Secret007 {
        String secretCode;
        Character meetingPoint;
        Integer time;

        public Secret007(String secretCode, Character meetingPoint, Integer time) {
            this.secretCode = secretCode;
            this.meetingPoint = meetingPoint;
            this.time = time;
        }

        @Override
        public String toString() {
            return "secret code : " + this.secretCode + "\n"
                    + "meeting point : " + this.meetingPoint + "\n"
                    + "time : " + this.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Secret007 secret = new Secret007(st.nextToken(), st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        System.out.println(secret);
    }
}