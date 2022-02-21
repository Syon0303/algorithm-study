package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-21, 30분
 * @title 비밀 이메일
 */

public class BOJ_B1_2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 정인이가 보내는 메세지의 총 글자수
        int N = str.length();

        // 행
        int R = 0;
        int max = Integer.MIN_VALUE;
        // 열
        int C = 0;

        // N까지 돌면서 나눗셈을 통해 R,C를 구해준다
        for (int i = 1; i <= N; i++) {
            C = i;
            if (N % C == 0) {
                R = N / C;
            }
            if (C >= R) {
                max = Math.max(max, R);
            }
        }

        // R이 가장 큰 것
        R = max;
        C = N / R;

        String res = "";

        // R번 돌면서 R씩 커지면서 C번 반복한다. ( 규칙 ) -> 0번째 다음 0+R번째 다음 0+R+R번째 순서대로 온다. 이것을 C번 반복. 이 전체 과정을 R번 반복
        for(int j=0;j<R;j++) {
            int cnt = j;
            for (int i = 0; i < C; i++) {
                res += str.charAt(cnt);
                cnt += R;
            }
        }

        System.out.println(res);
    }
}
