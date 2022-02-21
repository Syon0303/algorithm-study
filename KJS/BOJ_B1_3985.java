package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since  2022-02-20, 30분
 * @title 롤 케이크
 */

public class BOJ_B1_3985 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 롤 케이크 길이
        int L = Integer.parseInt(br.readLine());

        // 방청객의 수
        int N = Integer.parseInt(br.readLine());

        // 시작과 끝 값 저장하는 배열
        int[][] arr = new int[N+1][2];

        // 조각 받은지 체크
        boolean[] check = new boolean[L+1];

        // 제일 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호
        int max_index = -1;
        int wish_max = 0;

        // 제일 많은 조각을 받은 방청객의 번호
        int max_real_index = -1;
        int real_max = 0;
        int res = 0;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            // start
            int start = Integer.parseInt(st.nextToken());
            // end
            int end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;

            // 제일 많이 받을 것이라고 기대한 방청객 번호 구하기
            int minus = end - start;
            // 중복되면 통과
            if(max_index == minus){
                continue;
            }
            max_index = Math.max(max_index, minus);
            if(max_index == minus){
                wish_max = i;
            }

            real_max = 0;
            // 조각 체크 해주기
            for(int j=start; j<=end; j++){
                if(!check[j]) {
                    check[j] = true;
                    real_max++;
                }
                else if(check[j]){
                    continue;
                }
            }
            // 중복되면 통과
            if(max_real_index == real_max){
                continue;
            }
            max_real_index = Math.max(max_real_index, real_max);
            if(max_real_index == real_max){
                res = i;
            }
        }
        sb.append(wish_max).append("\n").append(res);

        System.out.println(sb);
    }
}
