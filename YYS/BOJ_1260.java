import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[] v;
	static int N;
	static StringBuilder sb = new StringBuilder();
	static void bfs(int init) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(init);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(!v[now]) {
				v[now] = true;
				sb.append(now+" ");
				for(int i=0; i<=N; i++) {
					if(arr[now][i]==1)q.offer(i);
				}
			}
		}
	}
	static void dfs(int now) {
		v[now] = true;
		sb.append(now+" ");
		for(int i=1; i<=N; i++) {
			if(!v[i] && arr[now][i]==1) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		arr = new int[N+1][N+1];

		while(M-->0) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arr[from][to]=1;
			arr[to][from]=1;
		}
		
		v = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		v = new boolean[N+1];
		bfs(V);
		System.out.println(sb.toString());
}
}