import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] v1,v2;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	
	static void dfs1(int row, int col, char c) { //정상인용 dfs
		if(row<0 || row>=N || col<0 || col>=N || v1[row][col] || map[row][col]!=c) {
			return;
		}
		v1[row][col] = true; //방문체크
		for(int i=0; i<4; i++) {
			dfs1(row+dx[i], col+dy[i],c);
		}
	}
	
	static void dfs2(int row, int col, char c) { //색약인용 dfs
		if(row<0 || row>=N || col<0 || col>=N || v2[row][col]) return;
		
		// R과 G과 서로 이동할 수 있도록 예외조건 만들기
		if((c=='R' && map[row][col]=='G') || (c=='G' && map[row][col]=='R')) {
			//이 경우는 예외로 합니다
		}else if(c!=map[row][col]) { // 그 외 다르면 가지치기
			return;
		}
		v2[row][col] = true;
		for(int i=0; i<4; i++) {
			dfs2(row+dx[i], col+dy[i],c);
		}
	}
	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   N = sc.nextInt();
	   map = new char[N][N]; //색상을 기록한 배열
	   
	   v1 = new boolean[N][N]; //정상인의 방문 배열
	   v2 = new boolean[N][N]; //색약인의 방문 배열
	   
	   int cnt1 = 0, cnt2 = 0; // 카운트해줄 변수
	   
	   for(int i=0; i<N; i++) {
		   String s = sc.next();
		   for (int j = 0; j < N; j++) {
			   map[i][j] = s.charAt(j);
		   }
	   }
	   for(int i=0; i<N; i++) { // 배열을 탐색하며 구역을 확인합니다.
		   for (int j = 0; j < N; j++) {
			   if(!v1[i][j]) {
				   cnt1++;
				   dfs1(i,j,map[i][j]);
			   }
			   if(!v2[i][j]) {
				   cnt2++;
				   dfs2(i,j,map[i][j]);
			   }
		   }
	   }
	   System.out.println(cnt1+" "+cnt2);
} 
}