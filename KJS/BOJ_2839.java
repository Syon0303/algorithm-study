package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-15, 1시간
 * @title 설탕 배달, 브론즈1
 */


public class BOJ_2839 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 설탕 무게
        int N = Integer.parseInt(br.readLine());

        // 안되는 경우
        if (N == 4 || N == 7) {
            System.out.println("-1");
        }
        // 5로 나누어 떨어 질 때
        else if (N % 5 == 0) {
            System.out.println(N / 5);
        } else if (N % 5 == 3 || N % 5 == 1) {
            System.out.println((N / 5) + 1);
        } else if (N % 5 == 4 || N % 5 == 2) {
            System.out.println((N / 5) + 2);
        }
    }
}
