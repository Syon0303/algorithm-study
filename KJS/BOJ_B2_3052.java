package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-26, 5분
 * @title 나머지
 *
 */
public class BOJ_B2_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 서로 다른 나머지 개수
        int cnt = 0;

        // 나머지 저장
        boolean[] v = new boolean[42];

        for(int i=0; i<10; i++){
            // 수 입력하고 나머지 구하기
            int temp = Integer.parseInt(br.readLine()) % 42;

            // 값이 있으면 통과
            if(v[temp]){
                continue;
            }
            // 값이 없으면
            else if(!v[temp]){
                v[temp] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
