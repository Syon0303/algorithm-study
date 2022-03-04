package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-03-04, 1시간 30분
 * @title 평범한 배낭
 */

public class BOJ_G5_12865 {
    static StringTokenizer st;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");

        // 물품의 수
        N = Integer.parseInt(st.nextToken());

        // 버틸 수 있는 무게
        K = Integer.parseInt(st.nextToken());

        // 무게와 가치 저장 배열
        int[][] arr = new int[N+1][2];

        // 물품의 무게 , 1~k 까지의 무게 , 값은 가치 누적이다
        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){

                // 들어갈 수 있는 무게인 경우
                if(j - arr[i][0] >= 0){
                    // dp에 저장된 누적 값과 현재 자신의 가치와 남은 무게의 가치를 비교하여 큰 값을 저장한다
                    dp[i][j] = Math.max(dp[i-1][j], arr[i][1] + dp[i-1][j-arr[i][0]]);
                }
                // 들어갈 수 없는 무게면 전행의 값을 가져온다
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
