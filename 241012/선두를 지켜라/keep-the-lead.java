import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    private static final int A = 1;
    private static final int B = 2;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        // 각각의 시간마다의 이동한 총 거리를 기록한다.
        addDistance(listA, n, br);
        addDistance(listB, m, br);
        
        // 경주 시작
        int cnt = 0;
        int winning = 0;
        for(int i=0; i<listA.size(); i++) {
            if(listA.get(i) > listB.get(i) && (winning == B || winning == 0)) {
                winning = A;
                cnt++;
            } else if(listA.get(i) < listB.get(i) && (winning == A || winning == 0)) {
                winning = B;
                cnt++;
            }
        }

        System.out.println(cnt-1);
    }
    
    static private void addDistance(List<Integer> list, int num, BufferedReader br) throws IOException {

        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j=0; j<t; j++) {
                if(list.isEmpty()) {
                    list.add(v);
                } else {
                    list.add(list.get(list.size() - 1) + v);
                }
            }
        }
    }
}