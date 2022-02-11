import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = 100;
		for (int i = 0; i < 10; i++) {
			int T = Integer.parseInt(br.readLine()); // 테이스 케이스
			int[][] ladder = new int[size][size];
			// 사다리 입력
			for (int j = 0; j < size; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < size; k++) {
					ladder[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			// 사다리 시작 지점 찾기
			boolean goal = false;
			int res = -1;
			for (int j = 0; j < size; j++) {
				// 시작 지점이 0인 경우 패스
				if(ladder[0][j] == 1) { // j = 사다리 위치
					int r = 0; // 사다리 세로 위치
					int c = j; // 사다리 가로 위치
					// 사다리 타기
					while(true) {
						// 사다리 오른쪽 탐색
						if(c+1 < size && ladder[r][c+1] == 1) {
							c++;
							while(true) {
								//오른쪽이 경계밖이거나 0이 나올때까지 이동
								if(c+1 >= size || ladder[r][c+1] == 0) {
									r++; // 아래쪽으로 한 칸 이동
									break;
								}else {
									c++; // 오른쪽으로 한 칸 이동
								}
							}
						// 사다리 왼쪽 탐색
						}else if(c-1 >= 0 && ladder[r][c-1] == 1) {
							c--;
							while(true) {
								//왼쪽이 경계밖이거나 0이 나올때까지 이동
								if(c-1 < 0 || ladder[r][c-1] == 0) {
									r++; // 아래쪽으로 한 칸 이동
									break;
								}else {
									c--; // 오른쪽으로 한 칸 이동
								}
							}
						// 마지막 사다리인 경우
						}else if(r == size-1) {
							// 원하는 지점일 경우  
							if(ladder[r][c] == 2) {
								goal = true;
								res = j;
								break;
							// 원하는 지점이 아니었을 경우
							}else {
								break;
							}
						// 나머지 경우 아래쪽으로 한 칸 이동
						}else {
							r++;
						}
					}
				}
				if(goal) break;
			}
			System.out.println("#"+T+" "+res);
		}
	}
}