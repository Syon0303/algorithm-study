package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-03-03, 35분
 * @title RGB거리
 */

public class BOJ_S1_1149 {
    static StringTokenizer st;
    static int red = 0;
    static int green = 1;
    static int blue = 2;

    static int[][] cost;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 집의 수
        int N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        DP = new int[N][3];

        red = 0;
        green = 1;
        blue = 2;


        // 입력

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 비용을 더해서 저장해준다
        DP[0][red] = cost[0][red];
        DP[0][green] = cost[0][green];
        DP[0][blue] = cost[0][blue];


        System.out.println(Math.min(sum(N-1,red), Math.min(sum(N-1,green), sum(N-1,blue))));


    }

    // 합을 더해주는 과정
    static int sum(int N, int color){

        // 아직 비용이 저장되지 않은 곳
        if(DP[N][color]==0){
            // red라면 현재 N에서의 비용을 더하고 그 전 줄에서의 red를 제외한 값들 중 작은 값을 더 해준다. -> 반복
            // 계속 타고타고 내려가면 0이 될 때 까지 내려가져서 실질적으론 그때부터 반대로 계산해서 올라와진다.
            if(color == red){
                DP[N][red] = cost[N][red] + Math.min(sum(N-1, green),sum(N-1,blue));
            }
            else if(color == green){
                DP[N][green] = cost[N][green] + Math.min(sum(N-1,red) , sum(N-1,blue));
            }
            else if(color == blue){
                DP[N][blue] = cost[N][blue] + Math.min(sum(N-1,red) , sum(N-1,green));
            }
        }

        return DP[N][color];
    }
}
