package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-03-10, 1시간
 * @title LCS
 */

public class BOJ_G5_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int length_1 = str1.length;
        int length_2 = str2.length;


        // 메모리제이션 할 배열, 공집합 표현을 위해 1개씩 추가
        int[][] dp = new int[length_1+1][length_2+1];

        for(int i=1; i<=length_1; i++){
            for(int j=1; j<=length_2; j++){

                // i-1 과 j-1 의 문자가 같다면
                if(str1[i-1] == str2[j-1]){
                    // 대각선 위 (i-1, j-1)의 dp 에 +1 해준다.
                    dp[i][j] = dp[i-1][j-1]+1;
                }

                // 같지 않다면
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[length_1][length_2]);


    }
}
