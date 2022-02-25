import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine()); // 판 크기
			int map[][] = new int[N][N];
			// map 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer stn = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(stn.nextToken());
				}
			}
			int res = 0; // 결과 값
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 빨간색이면
					if(map[i][j] == 1) {
						// 아래쪽 탐색
						for (int k = i+1; k < N; k++) {
							// 또 빨간색이 나오면 탐색 종료
							if(k < N && map[k][j] == 1) break;
							// 파란색이 나오면 
							if(k < N && map[k][j] == 2) {
								res++; // 결과 값 증가하고 종료
								break;
							}
						}
					}
				}
			}
			// 출력
			System.out.println("#"+t+" "+res);
		}
	}
}