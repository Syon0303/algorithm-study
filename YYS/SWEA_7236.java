import java.io.*;
import java.util.*;
public class Solution {
	static int[][] v;
	static char[][] map;
	static int N, cntW, cntR;
	static int max=0;
	static boolean judge;
	static int[] dx = {0,0,-1,1,-1,1,-1,1};
	static int[] dy = {-1,1,0,0,1,-1,-1,1};
	// W 상태에서 바깥 경계선에 닿으면 true
	static int Cal(int r, int c) {
		int cnt = 0;
		for(int i=0; i<8; i++) {
			int row = r+dx[i];
			int col = r+dy[i];
			if(row<0 || col <0 || row>=N || col>=N) {
				continue;
			}
			if(map[row][col]=='W') cnt++;
		}
		return cnt;
	}
	static void dfs(int row, int col) {
		if(row<0 || col <0 || row>=N || col>=N) {
			//System.out.println(row+" "+col);
			judge = true;
			return;
		}
		if(v[row][col]==1 || map[row][col]=='R') return;
		
		v[row][col] = 1;
		max = Math.max(max, Cal(row, col));
		for(int i=0; i<4; i++) {
			dfs(row+dx[i], col+dy[i]);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			v = new int[N][N];
			cntW = 0;
			cntR = 0;
			int MAX = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			judge = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(v[i][j] != 1 && map[i][j] =='W') { //방문하지 않았고
						dfs(i,j);
					//	System.out.println(i+" "+j);
						if(!judge) {
							MAX = Math.max(MAX, 1);
							// 둘러쌓였다면 1과 비교
						}else { //
							MAX = Math.max(MAX, max);
						}
						judge = false;
						max = 0;
					}
				}
			}
			System.out.println("#"+t+" "+MAX);
			
		}
	}

} 