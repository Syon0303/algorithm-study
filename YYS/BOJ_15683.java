import java.util.*;

public class Main {
	static int MIN=Integer.MAX_VALUE,d,N,M,map[][],v[][];
	static int[][] CCTV = new int[8][3]; //행, 렬, 카메라 종류
	
	static void dfs(int depth) {
		if(depth == d) {
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(v[i][j]==0) {
						cnt++;
					}
				}
			}
			if(MIN > cnt) {
				MIN = cnt;
			}
			return;
		}
		
		switch(CCTV[depth][2]) { //카메라 종류에 따라 쏠 수 있는 방향이 다름
			case 1:
				for(int i=0; i<4; i++) {
					shot(CCTV[depth][0],CCTV[depth][1],i);
					dfs(depth+1);
					cancel(CCTV[depth][0],CCTV[depth][1],i);
				}
				break;
			case 2:
				shot(CCTV[depth][0],CCTV[depth][1],0); //상
				shot(CCTV[depth][0],CCTV[depth][1],1); //하
				dfs(depth+1);
				cancel(CCTV[depth][0],CCTV[depth][1],0);
				cancel(CCTV[depth][0],CCTV[depth][1],1);
				
				shot(CCTV[depth][0],CCTV[depth][1],2); //좌
				shot(CCTV[depth][0],CCTV[depth][1],3); //우
				dfs(depth+1);
				cancel(CCTV[depth][0],CCTV[depth][1],2);
				cancel(CCTV[depth][0],CCTV[depth][1],3);
				break;
			case 3: // 직각 : 시계방향
				
				shot(CCTV[depth][0],CCTV[depth][1],0); //상좌
				shot(CCTV[depth][0],CCTV[depth][1],2);
				dfs(depth+1);
				cancel(CCTV[depth][0],CCTV[depth][1],2);
				shot(CCTV[depth][0],CCTV[depth][1],3); //상우
				dfs(depth+1);
				cancel(CCTV[depth][0],CCTV[depth][1],0);
				shot(CCTV[depth][0],CCTV[depth][1],1); //우하
				dfs(depth+1);
				cancel(CCTV[depth][0],CCTV[depth][1],3);
				shot(CCTV[depth][0],CCTV[depth][1],2); //하좌
				dfs(depth+1);
				cancel(CCTV[depth][0],CCTV[depth][1],2);
				cancel(CCTV[depth][0],CCTV[depth][1],1);
				break;
			case 4: // 세방향
				for(int i=0; i<4; i++) {
					for(int j=0; j<4; j++) {
						if(j==i)continue;
						shot(CCTV[depth][0],CCTV[depth][1],j);
					}
					dfs(depth+1);
					for(int j=0; j<4; j++) {
						if(j==i)continue;
						cancel(CCTV[depth][0],CCTV[depth][1],j);
					}
				}
				break;
			case 5:
				for(int i=0; i<4; i++) {
					shot(CCTV[depth][0],CCTV[depth][1],i);
				}
				dfs(depth+1);
				for(int i=0; i<4; i++) {
					cancel(CCTV[depth][0],CCTV[depth][1],i);
				}
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static void shot(int row, int col, int d) {
		//해당 위치에서 원하는 방향으로 쏴줌: 0(상), 1(하), 2(좌), 3(우)
		int r = row;
		int c = col;
		while(true) {
			r += dx[d];
			c += dy[d];
			if(r<0 || c<0 || r>=N || c>= M || v[r][c]==-1) break;
			
			v[r][c] += 1;
		}
		
	}
	static void cancel(int row, int col, int d) {
		//해당 위치에서 원하는 방향으로 쏴줌: 0(상), 1(하), 2(좌), 3(우)
		int r = row;
		int c = col;
		while(true) {
			r += dx[d];
			c += dy[d];
			if(r<0 || c<0 || r>=N || c>= M || v[r][c]==-1) break;
			
			v[r][c] -= 1;
		}
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		v = new int[N][M]; //방문 체크 배열
		
		int vacant = 0; //빈 곳 카운트
		d = 0; //카메라 카운트
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int num = sc.nextInt();
				map[i][j] = num;
				
				if(num==0) vacant++;
				else if(num!=6) {
					v[i][j] ++;
					CCTV[d][0] = i;
					CCTV[d][1] = j;
					CCTV[d][2] = num;
					d++;
				}else if(num==6) {
					v[i][j] = -1;
				}
				
			}
		}
		dfs(0);
		System.out.println(MIN);
	}
}