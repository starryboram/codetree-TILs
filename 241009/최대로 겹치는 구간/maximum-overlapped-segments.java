import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Panel {
        int start;
        int end;

        public Panel(int start, int end) {
            int base = 100;
            this.start = base + start;
            this.end = base + end;
        }
    }

    static final int MAX = 200;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Panel> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Panel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] line = new int[MAX];
        int ans = 0;
        for(int i=0; i<list.size(); i++) {
            Panel panel = list.get(i);
            for(int j=panel.start; j<panel.end; j++) {
                line[i]++;
                ans = Math.max(ans, line[i]);
            }
        }
        System.out.println(ans);
    }
}