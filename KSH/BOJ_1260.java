package day13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 롤 케이크 / 브론즈 1 / 15분
public class BOJ_1260 {

	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();
		int current = sc.nextInt();
		
		int[][] adjMatrix = new int[N][N];
		for(int i=0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from-1][to-1] = adjMatrix[to-1][from-1] = 1;
		}
		
		dfs(adjMatrix, new boolean[N], current-1);
		System.out.println();
		bfs(adjMatrix, current-1);
	}
	
	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] v = new boolean[N];
		queue.offer(start);
		v[start] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+1 + " ");
			
			for(int j=0; j<N; j++) {
				if(!v[j] && adjMatrix[current][j] != 0) {
					queue.offer(j);
					v[j] = true;
				}
			}
		}
	}
	
	public static void dfs(int[][] adjMatrix, boolean[] v, int current) {
		v[current] = true;
		System.out.print(current+1 + " ");
		
		for(int j=0; j<N; j++) {
			if(!v[j] && adjMatrix[current][j] != 0) {
				dfs(adjMatrix, v, j);
			}
		}
	}

}
