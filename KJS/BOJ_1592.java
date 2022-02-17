package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-16, 40분
 * @title 영식이와 친구들, 브론즈2
 *
 */

public class BOJ_1592 {
    static StringTokenizer st;
    static int N,M,L;
    static int[] cnt;
    // 결과 idx
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        // 사람 수
        N = Integer.parseInt(st.nextToken());

        // 공 받는 횟수 제한
        M = Integer.parseInt(st.nextToken());

        // 몇번째 사람에게 공을 주냐
        L = Integer.parseInt(st.nextToken());
        // 공 받은 횟수 세는 배열
        cnt = new int[N+1];

        int idx = 1;
        while(true){


            // 공 받은 횟수 +1
            cnt[idx]++;
            res++;

            if(cnt[idx] == M){
                break;
            }

            // 공 받은 횟수가 짝수
            if(cnt[idx] % 2 == 0){
                idx -= L;
                if (idx < 1) {
                    idx += N;
                }
            }
            // 공 받은 횟수가 홀수
            else {
                idx += L;
                if(idx>N){
                    idx -= N;
                }
            }
        }

        sb.append(res-1);
        System.out.println(sb);


    }
}
