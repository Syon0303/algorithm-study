import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		int map[][] = new int[21][21]; // 상하좌우로 배리어 씌움
		/* 바둑판 상황 입력 받기 */
		for (int i=1; i<=19; i++) {
			stn = new StringTokenizer(br.readLine());
			for (int j=1; j<=19; j++) {
				map[i][j] = Integer.parseInt(stn.nextToken());
			}
		}
		// 우상, 우, 우하, 하
		int dx[] = {1, 1, 1, 0};
		int dy[] = {-1, 0, 1, 1};
		// 좌하, 좌, 좌상, 상
		int ddx[] = {-1, -1, -1, 0};
		int ddy[] = {1, 0, -1, -1};
		boolean win = false; // 승자 결정 시 더 이상 for문 반복하지 않음
		for (int i=1; i<=19; i++) {
			for (int j=1; j<=19; j++) {
				/* 바둑알을 발견했을 때 */
				if(map[i][j] != 0) {
					// 4방위 탐색
					for (int k = 0; k < 4; k++) {
						int c = map[i][j]; // 현재 오목 색
						// 오목 +-1 칸에는 다른 색이 있고 오목이 형성되었을 경우
						// 배리어 씌웠기 때문에 경계 탐색안해도 됨
						if(map[i+ddy[k]][j+ddx[k]]!=c && map[i+dy[k]][j+dx[k]]==c && map[i+dy[k]*2][j+dx[k]*2]==c && 
								map[i+dy[k]*3][j+dx[k]*3]==c && map[i+dy[k]*4][j+dx[k]*4]==c && map[i+dy[k]*5][j+dx[k]*5]!=c) {
							System.out.println(c);
							System.out.println(i+" "+j);
							win = true;
						}
					}
				}
			}
			if(win) break;
		}
		if(!(win)) {
			System.out.println(0);
		}
	}
}
