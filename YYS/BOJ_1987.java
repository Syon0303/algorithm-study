import java.util.*;

public class Main {
	/** 알파벳을 숫자 표현 = 아스키 코드를 65로 나눈 나머지로 표현했습니다 */
	
	static int R,C,MAX=0; //변수들을 dfs 메소드에서 사용합니다
	static boolean[] v; //방문체크 배열
	static char arr[][]; //알파벳을 기록할 배열입니다
	static int[] dx = {0,0,1,-1}; //반복문으로 돌리기 위한 방향 배열입니다
	static int[] dy = {1,-1,0,0};
	
	static void dfs(int row,int col,int cnt) {
		if(row<0 || row >= R || col<0 || col>=C || v[(int)arr[row][col]%65]) {
			return;
		} // 가지치기를 이용해 경계값을 벗어나면 종료시키고 이미 방문한 곳이라도 종료시킵니다.
		
		cnt += 1; // 방문을 확정합니다. 현재까지 움직인 거리(cnt)에 1을 더합니다
		v[(int)arr[row][col]%65] = true; //방문체크
		
		MAX = Math.max(MAX, cnt); //최대값을 갱신합니다
		
		for(int i=0; i<4; i++) {
			dfs(row+dx[i],col+dy[i],cnt);
		}
		
		v[(int)arr[row][col]%65] = false; //방문해제
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		v = new boolean[26]; //방문 체크 배열: 알파벳 체크
		arr = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String s = sc.next();
			for(int j=0; j<C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		dfs(0,0,0); // (1, 1)부터 시작이지만 배열 상으론 (0, 0) 입니다
		System.out.println(MAX);
	}
}