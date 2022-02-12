package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-10, 20분
 * @title 색종이, 브론즈1
 * 
 */
public class BOJ_2563 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 합계
		int res = 0;

		// 색종이 수
		int N = Integer.parseInt(br.readLine());

		// x, y 좌푯값
		int[][] arr = new int[101][101];

		// 색종이 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int pap_x = Integer.parseInt(st.nextToken());
			int pap_y = Integer.parseInt(st.nextToken());

			for (int j = pap_x; j < pap_x + 10; j++) {
				for (int z = pap_y; z < pap_y + 10; z++) {

					// 만약 이미 거쳐 갔는 경우
					if (arr[z][j] == 1) {
						continue;
					} 
					// 처음 들리는 경우
					else {
						arr[z][j] = 1;
						res++;
					}
				}
			}
		}

		sb.append(res);
		System.out.println(sb);

	}
}
