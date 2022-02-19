import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테케
        for (int i = 1; i <= T; i++) {
			int[][] map = new int[9][9];
			boolean pass = true;
			boolean[] visited = new boolean[10];
			// 입력과 동시에 가로 검증
			for (int j = 0; j < 9; j++) {
				StringTokenizer stn = new StringTokenizer(br.readLine());
				visited = new boolean[10];
				for (int k = 0; k < 9; k++) {
					map[j][k] = Integer.parseInt(stn.nextToken());
					// 이미 중복된 곳을 찾았으면 입력만 받음
					if(pass) {
						// 방문했던 곳이면 실패
						if(visited[map[j][k]]) pass = false;
						visited[map[j][k]] = true;
					}
				}
			}
			// 세로 검증이 필요할 때만 검증
			if(pass) {
				// 세로 검증
				for (int j = 0; j < 9; j++) {
					visited = new boolean[10];
					for (int k = 0; k < 9; k++) {
						if(visited[map[k][j]]) pass = false;
						visited[map[k][j]] = true;
						// 중복된 곳 찾았으면 반복문 종료
						if(!pass) break;
					}
					if(!pass) break;
				}				
			}
			// 구역 검증
			int x, y, cx, cy;
			if(pass) {
				for (int j = 0; j < 9; j++) {
					cy = (j / 3) * 3;
					cx = (j % 3) * 3;
					visited = new boolean[10];
					for (int k = 0; k < 9; k++) {
						y = k / 3;
						x = k % 3;
						if(visited[map[cy+y][cx+x]]) pass = false;
						visited[map[cy+y][cx+x]] = true;
						if(!pass) break;
					}
					if(!pass) break;
				}
			}
			if(pass) System.out.println("#"+i+" "+1);
			else System.out.println("#"+i+" "+0);
        }
    }
}