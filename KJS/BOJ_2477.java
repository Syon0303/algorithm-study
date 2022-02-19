package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-19, 45분
 * @title 참외밭, 실버4
 */

public class BOJ_2477 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 참외의 개수
        int K = Integer.parseInt(br.readLine());

        // 방향과 길이 배열 저장
        int[][] arr = new int[6][2];

        // 입력
        for(int i =0; i<6; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int input = Integer.parseInt(st.nextToken());
            int input_l = Integer.parseInt(st.nextToken());

            arr[i][0] = input;
            arr[i][1] = input_l;
        }

        // 총 합
        int sum = 0;

        // 제일 큰 넓이
        int max = Integer.MIN_VALUE;

        for(int i=1; i<7; i++){
            int area = 0;
            if(i == 6){
                // 마지막 맨 뒤에서 맨 앞꺼 더하기
                area = arr[0][1] * arr[i-1][1];
            }
            else {
                // 사각형 넓이
                area = arr[i][1] * arr[i - 1][1];
            }
            // 제일 큰 넓이 구하기 = 기준이 되는 사각형
            max = Math.max(max, area);

            // 사각형의 모든 넓이 다 더하기
            sum += area;
        }

        // 결과
        int res = (max-((max*3)-sum));

        // 참외 수 구하기
        res *= K;

        System.out.println(res);
    }
}
