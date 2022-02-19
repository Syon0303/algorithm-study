package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-18, 20분
 * @title Z , 실버1
 */
public class BOJ_1074 {
    static StringTokenizer st;
    static int N, r, c, cnt;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        st = new StringTokenizer(br.readLine(), " ");
        // 배열의 크기
        N = Integer.parseInt(st.nextToken());

        // 행
        r = Integer.parseInt(st.nextToken());
        // 열
        c = Integer.parseInt(st.nextToken());

        int temp = (int) Math.pow(2, N);

        dfs(temp, 0,0);
    }

    static void dfs(int n, int x, int y) {
        // 기저조건
        if (x == c && y == r) {
            System.out.println(cnt);
            return;
        }

        // 위치마다 재귀 호출
        if (y <= r && r < (y + n) && x <= c && c < (x + n)) {
            int next_n = n / 2;
            dfs(next_n, x, y);
            dfs(next_n, x + next_n, y);
            dfs(next_n, x, y + next_n);
            dfs(next_n, x + next_n, y + next_n);
        }
        else{
            cnt += n*n;
        }
    }
}
