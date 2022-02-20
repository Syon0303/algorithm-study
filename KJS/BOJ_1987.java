package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-17, 21 35
 * @title 알파벳, 골드4
 */
public class BOJ_1987 {
    static StringTokenizer st;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int R, C;
    static boolean[][] isChecked;
    static int nx,ny;
    // 총 횟수 카운팅
    static int cnt;
    static int max = Integer.MIN_VALUE;
    static boolean[] alp;
    static char[][] arr;
    static int i =0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        // 세로
        R = Integer.parseInt(st.nextToken());

        // 가로
        C = Integer.parseInt(st.nextToken());

        // 입력값 저장
        arr = new char[R][C];

        // 지나갔는지 체크
        isChecked = new boolean[R][C];

        // 수 체크
        alp = new boolean[26];

        // 배열 입력
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        check(0,0);
        System.out.println(max);
    }

    static void check(int x, int y) {
        if(x < 0 || x == R || y < 0 || y == C ||  alp[(arr[x][y]-65)] == true) {
            return;
        }

        // 방문을 안했으면 true로 바꿔주고 하나 카운팅

        alp[(arr[x][y]-65)] = true;
        cnt++;

        max = Math.max(max, cnt);


        for (int z = 0; z < 4; z++) {
            nx = dx[z] + x;
            ny = dy[z] + y;

            check(nx,ny);
        }
        alp[(arr[x][y]-65)] = false;
        cnt--;
    }

}

