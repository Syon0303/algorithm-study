package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-23,20분
 * @title 촌수 계산
 *
 */
public class BOJ_S2_2644 {
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] v;
    static int cnt, res;
    static int n;
    static int res_start, res_end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 전체 사람의 수
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        // 계산해야하는 촌수
        res_start = Integer.parseInt(st.nextToken());
        res_end = Integer.parseInt(st.nextToken());

        // 관계의 개수
        int m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        v = new boolean[n + 1][n + 1];

        res = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = arr[end][start] = 1;
        }

        dfs(res_start);

        // 아무것도 없으면 -1 출력
        if (res == 0) {
            sb.append(-1);
        } else {
            sb.append(res);
        }
        System.out.println(sb);

    }

    static void dfs(int start) {
        // 기저 조건
        if (start == res_end) {
            res = cnt;
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (arr[start][i] == 1 && !v[start][i]) {
                // 방문 처리
                v[start][i] = v[i][start] = true;
                cnt++;
                dfs(i);
                // 아닌경우엔 돌아와서 cnt -1 해주기
                cnt--;
            }
        }
    }

}
