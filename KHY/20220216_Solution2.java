import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테케
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine()); // 커맨드 수
            int v = 0; // 현재 속력
            int res = 0; // 총 이동 거리
            for (int j = 0; j < N; j++) {
                StringTokenizer stn = new StringTokenizer(br.readLine());
                int com = Integer.parseInt(stn.nextToken()); // 커맨드
                int a = 0;
                if(com != 0) {
                    a = Integer.parseInt(stn.nextToken()); // 가속도                   
                }
                // 1일 경우
                if(com == 1) {
                    v = v + a; // 가속
                // 2일 경우
                }else if(com == 2) {
                    v = v - a; // 감속
                    if(v < 0) v = 0; // 음수면 0으로 처리
                }
                res += v;
            }
             
            System.out.println("#"+i+" "+res);
        }
    }
}