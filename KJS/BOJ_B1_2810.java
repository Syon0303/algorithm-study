package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-26, 15분
 * @title 컵홀더
 */

public class BOJ_B1_2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 좌석의 수
        int N = Integer.parseInt(br.readLine());

        // 최대 사람 수
        int res = 0;

        String str = br.readLine();

        // L 개수®
        int cnt = 0;
        for(int i=0; i<N; i++){
            if(str.charAt(i) == 'L'){
                cnt++;
            }
        }

        // L 이 한개도 없는 경우 -> 다 S
        if(cnt == 0){
            res = N;
        }
        else {
            res = N - (cnt / 2) + 1;
        }

        System.out.println(res);

    }
}
