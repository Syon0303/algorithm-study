package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-03-08. 40분
 * @title 가장 긴 증가하는 부분 수열
 */

public class BOJ_S2_11053 {
    static StringTokenizer st;
    static int[] arr, dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기
        N = Integer.parseInt(br.readLine());

        // 수열 값 저장
        arr = new int[N];

        // 비교한 값 저장
        dp = new int[N];

        // 처음 값은 0 이다
        int LIS = 0;

        // 배열 입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){

            // dp 배열에 저장될 위치
            int idx = BinarySearch(arr[i], 0, LIS, LIS+1);

            // 못찾은경우
            if(idx == -1){
                dp[LIS] = arr[i];
                LIS++;
            }
            // 찾은 경우
            else{
                dp[idx] = arr[i];
            }
        }
        System.out.println(LIS);
    }

    // 이분 탐색을 이용하여 dp 테이블에 저장된 원소를 탐색하여 현재 선택된 숫자가 dp테이블의 어떤 위치에 포함될지 찾는다
    public static int BinarySearch(int num, int start, int end, int size) {
        int res = 0;
        while(start<=end){
            // 중앙 값을 찾는다
            int mid = (start+end)/2;

            // 현재 선택된 원소가 해당 원소보다 작거나 같다면 앞부분 탐색
            if(num <= dp[mid]){
                res = mid;
                end = mid-1;
            }
            // 현재 선택된 원소가 해당 원소보다 크다면 뒷 부분 탐색
            else {
                start = mid + 1;
            }
        }
        // dp 테이블에서 삽입될 위치를 못찾은 경우 ( 모든 수들보다 큰 경우 )
        if(start==size){
            return -1;
        }
        // dp 테이블에서 삽입될 위치를 찾은 경우
        else{
            return res;
        }
    }
}
