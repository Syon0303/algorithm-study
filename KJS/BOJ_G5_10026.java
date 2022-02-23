package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-23, 35분
 * @title 적록색약
 */

public class BOJ_G5_10026 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0,};
    static char[][] arr;
    static int N;
    static boolean[][] v;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 크기
        N = Integer.parseInt(br.readLine());

        // 입력
        arr = new char[N+1][N+1];
        v = new boolean[N+1][N+1];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        // 기본
        // 배열을 돌면서 아직 방문하지 않았으면 dfs탐색

        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!v[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append(" ");

        // 색맹
        // G를 R로 바꿔주고 dfs탐색

        cnt = 0;
        v = new boolean[N+1][N+1];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 'G'){
                    arr[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!v[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        sb.append(cnt);

        System.out.println(sb);
    }


    // 깊이 우선 탐색
    static void dfs(int x, int y) {
        v[x][y] = true;
        char num = arr[x][y];


        for (int z = 0; z < 4; z++) {
            int nx = x + dx[z];
            int ny = y + dy[z];

            if (nx < 0 || ny < 0 || nx > N || ny > N) {
                continue;
            }
            else if (!v[nx][ny] && arr[nx][ny] == num) {
                dfs(nx, ny);
            }
        }
    }
}


