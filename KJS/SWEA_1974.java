package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-18, 30분
 * @title 스도쿠 검증 , D2
 */
public class SWEA_1974 {
    static StringTokenizer st;
    static boolean[] check_col;
    static boolean[] check_row;
    static boolean[] check_rec;
    static int[][] arr;
    static boolean check_b = false;
    static boolean rec_b = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int tc = Integer.parseInt(br.readLine());


        for (int T = 1; T <= tc; T++) {
            arr = new int[9][9];

            sb.append("#").append(T).append(" ");

            // 배열 입력
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기 결과 boolean 값 초기화
            check_b = false;
            rec_b = false;


            for (int i = 0; i < 9; i++) {
                col(i);
                // 이미 중복되면 뒤에 볼 필요가 없음
                if (check_b) {
                    break;
                }
            }
            // 이미 겹치면 뒤에 볼 필요가 없음
            if (check_b) {
                sb.append(0).append("\n");
                continue;
            }
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    rec(i, j);
                    // 이미 중복되면 뒤에 볼 필요가 없음
                    if (rec_b) {
                        break;
                    }
                }
            }
            if (rec_b) {
                sb.append(0).append("\n");
                continue;
            }
            // 겹치지 않는 경우
                sb.append(1).append("\n");
       }
        System.out.println(sb);
    }

    // 가로를 검사
    static void col(int n) {
        check_col = new boolean[10];
        check_row = new boolean[10];
        for (int i = 0; i < 9; i++) {
            // 이미 있으면
            if (check_col[arr[n][i]] == true || check_row[arr[i][n]] == true) {
                // 겹치는게 있으면 true , 종료
                check_b = true;
                break;
            }
            // 있는 것을 표시
            check_col[arr[n][i]] = true;
            check_row[arr[i][n]] = true;
        }
    }

    // 사각형을 검사
    static void rec(int start_col, int start_row) {

        check_rec = new boolean[10];
        for (int i = start_col; i < start_col + 3; i++) {
            for (int j = start_row; j < start_row + 3; j++) {
                if (check_rec[arr[i][j]]) {
                    // 겹치는게 있으면 true , 종료
                    rec_b = true;
                    break;
                }
                // 있는 것을 표시
                check_rec[arr[i][j]] = true;
            }
        }
    }
}
