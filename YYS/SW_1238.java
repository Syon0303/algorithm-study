import java.io.*;
import java.util.*;
public class Solution {
	static boolean[][] arr;
	static int N,MAX,v[];
	
	
	static void bfs(int init) { //재귀의 깊이 / 현재 노드 번호
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[]{1,init}); // 깊이는 1로 시작
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int depth = now[0];
			int number = now[1];
			if(v[number]==0) { // 방문체크에서 boolean이 아닌 재귀의 깊이를 기록했습니다.
				v[number] = depth; //그래서 방문하는 순간 몇 번째 방문인지 파악할 수 있습니다.
				MAX = Math.max(MAX, depth); //재귀의 깊이 최대값 갱신: 이후 같은 재귀 깊이중 최대 숫자를 구하기 위함

				for(int i=0; i<101; i++) {
					if(v[i]==0 && arr[number][i]) {
						q.offer(new int[] {depth+1,i});
					}
				}
			}
		}
	}
public static void main(String[] args) throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st;
	 for(int t=1; t<=10; t++) {
		 st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken()); //입력 개수
		 int V = Integer.parseInt(st.nextToken()); //시작점
		 v = new int[101]; //방문체크 배열
		 arr = new boolean[101][101]; //인접행렬: 최대수는 100까지
		 
		 MAX = 0; //재귀 깊이의 최대값을 기록할 변수
		 st = new StringTokenizer(br.readLine()); //연결 정보를 가져옵니다
		 for(int i=0; i<N/2; i++) {
			 arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		 }

		 bfs(V); //재귀깊이는 1으로 시작하고 노드는 V부터 시작합니다.

		 int answer = 0; // 정답을 구할 변수입니다

		 for(int i = 100; i>=1; i--) {
			 if(v[i]==MAX) {
				 answer = i; // 끝에서부터 조사해서 MAX값과 같은 깊이를 가지면 정답입니다.
				 i=0;
			 }
		 }
		 
		 System.out.println("#"+t+" "+answer);
	 }
	 
}
}