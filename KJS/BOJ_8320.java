package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-18, 10분
 * @title 직사각형을 만드는 방법, 브론즈2
 */

public class BOJ_8320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 길이가 1인 정사각형
        int N = Integer.parseInt(br.readLine());

        // 만들수 있는 총 직사각형
        int res = 0;
        // 한 줄 인 경우
        res += N;

        // 한 줄 이상인경우 -> 곱해서 N이하
        for(int i=2; i<N; i++){
            for(int j=i; j<=N/2; j++){
                if(i*j<=N){
                    res++;
                }
            }
        }
        System.out.println(res);

    }
}
