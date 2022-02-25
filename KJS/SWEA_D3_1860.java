package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-25, 30분
 * @title 진기의 최고급 붕어빵
 */

public class SWEA_D3_1860 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine(), " ");
            // 사람수
            int N = Integer.parseInt(st.nextToken());

            // 초
            int M = Integer.parseInt(st.nextToken());

            // 붕어빵 개수
            int K = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                // 걸리는 시간
                list.add(Integer.parseInt(st.nextToken()));
            }
            // 정렬
            Collections.sort(list);

            // 붕어빵 수
            int cnt =0;

            int idx = 0;
            String res = "";
            // i는 시간을 의미
            for(int i = 1; i<=list.get(list.size()-1); i++) {
                if (i % M == 0) {
                    cnt += K;
                }
                if (list.get(idx) == i) {
                    if (cnt == 0) {
                        res = "Impossible";
                        break;
                    }
                    else{
                        res = "Possible";
                        cnt--;
                    }
                    idx++;
                }
            }

            if(res.equals("")){
                res = "Impossible";
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
