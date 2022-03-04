package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-03-03, 20분
 * @title 01타일
 */

public class BOJ_S3_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크기가 N
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        arr[0] = 1;
        if(N>1) arr[1] = 2;
        if(N<=2) System.out.println(arr[N-1]);

        else {
            for (int i = 2; i < N; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
            }
            System.out.println(arr[N-1]);
        }


    }
}

