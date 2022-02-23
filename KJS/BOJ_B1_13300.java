package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * @author us13579
 * @since 2022-02-22, 10분
 * @title 방 배정
 */

public class BOJ_B1_13300 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");

        // 학생 수
        int N = Integer.parseInt(st.nextToken());

        // 한 방에 배정하는 최대 인원 수
        int K = Integer.parseInt(st.nextToken());

        // 학생 수 저장 배열
        int[][] arr = new int[2][7];

        // 총 방 수
        int res = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            arr[S][Y]++;
        }

        for (int i = 1; i < 7; i++) {

            for (int j = 0; j < 2; j++) {

                // 아무도 없는 성, 학년이면 통과 ( 가지치기 )
                if (arr[j][i] == 0) {
                    continue;
                }

                // 한 방으로 수용할 수 있는 학생 수 인 경우
                else if (arr[j][i] <= K) {
                    res++;
                }

                // 여러 방이 필요한 경우
                else if (arr[j][i] > K) {
                    int temp = arr[j][i] / K;

                    // 만약 방이 수용할 수 있는 인원이랑 맞게 떨어진다면
                    if (arr[j][i] % K == 0) {
                        res += temp;
                    }

                    // 맞게 떨어지지 않는 다면 방 하나를 더 써야한다
                    else {
                        res += (temp + 1);
                    }
                }


            }
        }

        System.out.println(res);
    }
}
