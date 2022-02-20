package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-18, 1시간10분
 * @title 빵집, 골드2
 */

public class BOJ_3109 {
    static StringTokenizer st;
    static boolean[][] visited;
    static int[][] arr;
    static int R, C;
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    // 파이프라인의 최대 개수
    static int cnt;
    static int nx, ny;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        // 행
        R = Integer.parseInt(st.nextToken());
        // 열
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        // true면 건물이나 지나간 자리 , false면 지나갈 수 있는 자리
        visited = new boolean[R + 1][C + 1];


        // 배열 입력
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'x') {
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }
        System.out.println(cnt);

    }


    // void 가 아닌 boolean으로 받음으로서 끝에 도착하면 나올 수 있었다!!
    static boolean dfs(int y, int x) {
        // 기저조건 : 끝에 도착하는 경우 카운팅 ++
        if (x == C - 1) {
            cnt++;
            return true;
        }


        visited[y][0] = true;
        // 3방향 탐색
        // 위 중간 아래 하는 것이 포인트 !! 촤대 개수이기 때문에
        for (int z = 0; z < 3; z++) {
            nx = x + dx[z];
            ny = y + dy[z];


            //못감
            if (nx < 0 || ny < 0 || ny >= R || visited[ny][nx] == true) {
                continue;
            }

            // 갈 수 있는 곳
            if (!visited[ny][nx]) {
                visited[ny][nx] = true;
                if(dfs(ny, nx)){
                    return true;
                }
            }
        }
        return false;
    }
}
