package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-15, 10분
 * @title 동전 0, 실버3
 */

public class BOJ_11047 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        st = new StringTokenizer(br.readLine(), " ");
        // 동전의 종류
        int N = Integer.parseInt(st.nextToken());

        // 가치의 합
        int K = Integer.parseInt(st.nextToken());

        // 동전 배열
        int[] arr = new int[N];

        // 동전 개수의 최솟값
        int res = 0;

        // 동전 입력 받기
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = N-1;

        while(K!=0){
            // K가 배열의 원소보다 클 경우 빼준다
            if(K>=arr[idx]){
                while(K>=arr[idx]){
                    K -= arr[idx];
                    res++;
                }
            }
            idx--;
        }
        sb.append(res);
        System.out.println(res);
    }
}
