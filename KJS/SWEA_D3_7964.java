package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-23, 15분
 * @title 부먹왕국의 차원 관문
 */

public class SWEA_D3_7964 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스크 케이스 수
        int tc = Integer.parseInt(br.readLine());

        for (int T = 1; T <= tc; T++) {
            sb.append("#").append(T).append(" ");

            st = new StringTokenizer(br.readLine(), " ");

            // 도시의 수
            int N = Integer.parseInt(st.nextToken());

            // 이동제한거리
            int D = Integer.parseInt(st.nextToken());

            // 차원관문 정보 배열
            int[] arr = new int[N];

            // 추가할 차원관문 수
            int cnt = 0;

            // 0의 개수 체크해주는 수
            int check = 0;


            st = new StringTokenizer(br.readLine(), " ");
            // 입력
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                // 0 의 개수가 D 까지 도달하는지 체크
                if (arr[i] == 0) {
                    check++;
                    // D 값이 되면 차원관문 한 개 추가해주고 0으로 초기화
                    if (check == D) {
                        cnt++;
                        check = 0;
                    }
                    // 1 을 만나면 check 초기화 ( 차원관문을 통과했기 때문 )
                } else if (arr[i] == 1) {
                    check = 0;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
