package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-26, 30분
 * @title 백만 장자 프로젝트
 */

public class SWEA_D2_1859 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            sb.append("#").append(t).append(" ");

            // 연속된 일 수
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            // N의 범위 클 경우 합의 크기가 int 범위를 초과한다
            long res = 0;

            for(int i =N-1; i>=0; i--){
                // 배열값이 더 큰 경우 최댓값이 바뀐다
                if(max < arr[i]){
                    max = arr[i];
                }
                // 그렇지 않은 경우 최댓값에서 배열 값을 뺀 값이 이득 본 값
                else{
                    res += (max - arr[i]);
                }
            }

            sb.append(res);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
