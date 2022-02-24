import java.io.*;
import java.util.*;
public class Main {
	static int[][] ans;
	static int N, map[][], visit[][],cnt=0;
	static int[] now = {0,0,0,0}; // 아기 상어의 현재 위치를 기록: 행, 렬, 사냥 시도 번호, 움직인 숫자 
 	static int baby = 2; // 처음 아기 상어의 크기
 	static int eat = 0;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static Queue<int[]> q = new LinkedList<int[]>();
	
	static void bfs() { //BFS
		now[2] = 1; // 사냥 번호 = 1
		q.add(now); // 현재 물고기의 위치와 사냥번호, 이동 거리 =0  출발
		
		visit[now[0]][now[1]] = 1; //사냥 중인 숫자로 방문체크
		
		int min = Integer.MAX_VALUE; // 순간순간 최소 거리 후보들을 구하기 위한 변수
		
		int[][] tmp = new int[20][2]; // 후보들을 모아두는 곳
		int tmpIdx = 0;
		
		while(!q.isEmpty()) {
			int[] present = q.poll();
			// 0: 행, 1: 열, 2: 사냥 번호, 3: 현재까지 움직인 거리

			if(min<present[3]+1) {
				//System.out.println(min+" "+present[3]);
				tmp = Arrays.copyOf(tmp, tmpIdx);
				Arrays.sort(tmp,(o1,o2)->{
					if(o1[0]==o2[0]) {
						return Integer.compare(o1[1], o2[1]);
					}else {
						return Integer.compare(o1[0], o2[0]);
					}
				});
				//System.out.println(tmp[0][0]+" "+tmp[0][1]);
				
				eat++;
				if(eat==baby) {
					eat = 0;
					baby++;
				}
				int x = tmp[0][0];
				int y = tmp[0][1];
				map[x][y] = 0;
				cnt += min;
				q.clear();
				q.offer(new int[] {x,y,present[2]+1,0});
				tmp = new int[20][2];
				tmpIdx = 0;
				min = Integer.MAX_VALUE;
				continue;
			}
			for(int i=0; i<4; i++) {
				int x = present[0]+dx[i];
				int y = present[1]+dy[i];
				if(x>=0 && x<N && y>=0 && y<N && visit[x][y]!=present[2] && map[x][y]<=baby && min >= present[3]+1) {
					visit[x][y] = present[2];
					
					if(map[x][y]!=0 && map[x][y]<baby) {
						//System.out.println(x+" "+y+" "+present[2]);
						min = Math.min(min, present[3]+1);
						tmp[tmpIdx][0] = x; //후보 넣어주기
						tmp[tmpIdx][1] = y;
						tmpIdx ++;
//						for(int k=0; k<tmpIdx; k++) {
//							System.out.println(tmp[k][0]+" "+tmp[k][1]);
//						}
						//System.out.println(min);
						q.offer(new int[]{x,y,present[2],present[3]+1});
						i=4;
						continue;
					}
					
					q.offer(new int[]{x,y,present[2],present[3]+1});

				}
			}
		}
	}
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	//아기 상어는 처음에 크기 2
	// 크기가 큰 물고기는 못지나감, 같거나 작으면 지나감
	// 작은 물고기만 먹기 가능: 먹는 시간 X
	// 먹을 수 있는 물고기가 없다면 도움 요청
	// 가장 가까운 거리로 이동: 이동마다 1초
	//혼자 먹을 수 있는 초 계산
	// 9 아기상어 위치. 0 빈칸
	// 위 > 왼쪽
	// 동심원으로 해보자
	
	N = Integer.parseInt(br.readLine());
	map = new int[N][N];
	visit = new int[N][N];
	ans = new int[N][N];
	for (int i = 0; i < N; i++) { //값 입력부
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < N; j++) {
			map[i][j] = Integer.parseInt(st.nextToken());
			if(map[i][j]==9) {
				now[0] = i;
				now[1] = j;
				map[i][j] = 0;
			}
		}
	}
	bfs();
	System.out.println(cnt);
}
}