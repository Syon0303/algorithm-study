package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-17, 30분
 * @title 슈퍼 마리오, 브론즈1
 */

public class BOJ_2851 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 합
        int sum = 0;

        //  합 이전 값
        int sum_before = 0;

        int[] arr = new int[10];

        // 결과
        int res = 0;
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 10; i++) {
            sum_before = sum;
            sum += arr[i];

            // 합이 100인 경우
            if (sum == 100) {
                res = 100;
                break;
            }
            // 전 값은 100보다 작고 현재 값은 100보다 클 때
            else if (sum_before < 100 && sum > 100) {
                // 두개의 차이가 같거나 전값이랑 더 크으면 더 큰 값을 선택
                if ((100-sum_before) >= (sum - 100)) {
                    res = sum;
                    break;
                }
                // 아니면 100보다 작은 값을 선택
                res = sum_before;
                break;
            }
            // 다 안된 경우
            else if(i == 9 && res ==0){
                res = sum;
            }
        }
        System.out.println(res);
    }

}

