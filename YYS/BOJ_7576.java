import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = {0,0,1,-1};
		int[] dy = {-1,1,0,0}; //좌표배열입니다
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int MAX = 0;
		Queue<int[]> q = new LinkedList<int[]>(); // 가중치가 없는 최소경로: BFS 사용 
		// 토마토의 좌표와 날짜를 기록하기 위해 배열로 집어넣습니다.
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.offer(new int[] {i,j,0}); // 토마토가 있으면 큐에 넣어줍니다
				}
			}
		}
		

		while(!q.isEmpty()) {
			int[] tomato = q.poll(); //토마토를 꺼내고
			int day = tomato[2]; //날짜와 아래에서 좌표를 4방으로 돌려줍니다
			
			for(int i=0; i<4; i++) {
				int row = tomato[0]+dx[i];
				int col = tomato[1]+dy[i];
				//System.out.println(row+" "+col);
				if(row<0 || row>=N || col<0 || col>=M || map[row][col]!=0) {
					continue; //가지치기 합니다: 경계를 벗어나거나 이미 방문한 곳이면
				}
				//System.out.println(row+" "+col);
				map[row][col] = day+1; //가장 나중에 나온 토마토의 날짜가 곧 최대(BFS 특성)
				MAX = day+1;
				q.add(new int[] {row,col,day+1});
				
			}
		}
		boolean judge = true;
		for(int i=0; i<N; i++) { //0이있다면 익지 않은 토마토가 있다는 뜻
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					judge = false;
					i=N;
					j=M;
				}
			}
		}
		System.out.println(judge?MAX:-1);
	}

}