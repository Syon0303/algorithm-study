package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-19, 15분
 * @title 벌집, 브론즈2
 */

public class BOJ_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N번 방
        int N = Integer.parseInt(br.readLine());

        // 1번 방 들리고 시작
        int cnt = 1;

        // 6을 곱하는 횟수
        int idx = 1;

        if( N==1 ){
            cnt = 1;
        }

        // 6의 배수를 계속 빼면서 카운팅
        while(N>1){
            N -= (6*idx);
            cnt++;
            idx++;
        }

        System.out.println(cnt);
    }
}
