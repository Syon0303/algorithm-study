package day15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 촌수계산, 실버 2, 30분
public class BOJ_2644 {

	static int N;
	static int[][] map;
	static boolean[] v;
	static int[] cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		cnt = new int[N+1];
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		int C = sc.nextInt();
		
		for(int i=0; i<C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from][to] = map[to][from] = 1;
		}
		bfs(start, end);
	}
	
	public static void bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<Integer>();
		v = new boolean[N+1];
		queue.offer(start);
		v[start] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current == end) break;
			
			for(int i=1; i<=N; i++) {
				if(map[current][i]!=0 && !v[i]) {
					queue.offer(i);
					v[i] = true;
					cnt[i] = cnt[current]+1;
				}
			}
		}
		if(cnt[end] == 0) System.out.println(-1);
		else System.out.println(cnt[end]);
	}

}
