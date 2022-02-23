package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-23, 30분
 * @title 섬의 개수
 */

public class BOJ_S2_4963 {
    static StringTokenizer st;
    static int[][] arr;
    static int w, h;
    static boolean[][] v;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");

            // 너비 w, 높이 h
            w = Integer.parseInt(st.nextToken());

            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            // 지도
            arr = new int[h][w];

            // 섬인지 아닌지 check
            v = new boolean[h][w];

            // 섬의 개수
            int cnt = 0;

            // 지도 입력
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !v[i][j]) {
                        dfs(j, i);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);


    }

    static void dfs(int x, int y) {
        v[y][x] = true;

        int nx, ny;
        for (int z = 0; z < 8; z++) {
            nx = x + dx[z];
            ny = y + dy[z];

            if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                continue;
            } else if (arr[ny][nx] == 1 && !v[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }

}
