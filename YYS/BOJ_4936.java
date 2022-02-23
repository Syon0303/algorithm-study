import java.io.*;
import java.util.*;
public class Main {
	static int w,h,cnt;
	static boolean[][] map;
	
	static int[] dx = {0,0,1,-1,1,-1,-1,1}; //8방좌표
	static int[] dy = {1,-1,0,0,1,-1,1,-1};
	
	static void dfs(int row, int col) { // dfs를 통한 영역체크
		if(row<0 || row>=h || col<0 || col>=w || !map[row][col]) return;
		
		map[row][col] = false; //이미 밟은 곳은 바다로 변경 (true: 땅, false: 바다) 
		
		for(int i=0; i<8; i++) {
			dfs(row+dx[i],col+dy[i]); //팔방으로 다음 재귀 호출
		}
	}
	

public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	while(true) { 
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		cnt = 0;
		if(w==0 && h==0) break;
		
		map = new boolean[h][w]; //행/렬 순서 주의
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				if(st.nextToken().equals("1")) {
					map[i][j] = true; //땅은 true 표기
				}
			}
		}
		
		for(int i=0; i<h; i++) { // 전체 맵 탐색하면서 dfs 호출, 카운트
			for(int j=0; j<w; j++) {
				if(map[i][j]) {
					cnt++;
					dfs(i,j);
				}
			}
		}
		System.out.println(cnt);
	}

}
}