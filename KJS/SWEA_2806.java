package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-17, 20분
 * @title N-Queen, D3
 */


public class SWEA_2806 {
    // 결과 - 경우의 수
    static int res;

    // 배열
    static int[] arr;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int T = 1; T <= TC; T++) {
            sb.append("#").append(T).append(" ");

            // 보드의 크기
            N = Integer.parseInt(br.readLine());

            // 열의 위치값 저장 배열
            arr = new int[N];

            res = 0;
            go(0);

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    // 재귀 - 순열
    static void go(int row) {
        // 기저조건
        if (row == N) {
            // 조건에 충족한 값이 끝까지 들어왔으므로
            res++;
            return;
        }

        for (int i = 0; i < N; i++) { // 행 돌면서 열의 위치값 저장, 재귀 호출
            arr[row] = i; // 행 돌면서 열의 위치값 저장

            // 조건 충족하면 다음 재귀 호출
            // 가지치기 조건
            if (check(row)) {
                go(row + 1);
            }
        }

    }

    // 조건 메서드
    static boolean check(int row) {
        for(int i=0; i<row; i++) {
            // 같은 열에 위치
            if(arr[row] == arr[i]) {
                return false;
            }

            // 대각선에 위치
            if(row-i == Math.abs(arr[row] - arr[i])) {
                return false;
            }

            // 같은 행에 위치
            if(row == i) {
                return false;
            }
        }
        return true;
    }
}
