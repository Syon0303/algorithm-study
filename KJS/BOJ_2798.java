package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-16, 15분
 * @title 블랙잭, 브론즈2
 */
public class BOJ_2798 {
    static StringTokenizer st;
    static int N,M;
    static int[] arr;
    static int[] cal;
    static int sum;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        st = new StringTokenizer(br.readLine(), " ");
        // 카드의 개수
        N = Integer.parseInt(st.nextToken());

        // 숫자 M
        M = Integer.parseInt(st.nextToken());


        // 카드 입력
         arr = new int[N];

         // 계산 배열
         cal = new int[3];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combination(0,0);
        sb.append(max);
    }

    // 조합 구하기
    static void combination(int current, int idx){
        // 기저조건 : 3개 뽑으면 합계 구하기
        if(current == 3){
           for(int i=0; i<cal.length;i++){
               sum += cal[i];
           }

           // 합이 M보다 작거나 같으면 최댓값 비교
           if(sum <=M){
               max = Math.max(max, sum);
           }

           // sum 초기화 !!
           sum = 0;
            return;
        }

        // 값 배열에 저장하고 다음 재귀 호출
        for(int i=idx; i<N; i++){
            cal[current] = arr[i];
            combination(current+1,i+1);
        }


    }

}
