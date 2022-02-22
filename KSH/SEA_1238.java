package day13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Contact / D4 / 2시간
public class SEA_1238 {
	static int MAX;
	static int start;
	static int[][] adjMatrix;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case=1; test_case<=T; test_case++) {
			int C = sc.nextInt();
			start = sc.nextInt();

			adjMatrix = new int[101][101];

			for(int i=0; i<C/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adjMatrix[from][to] = 1;
			}
			bfs();
			System.out.println("#"+test_case+ " " + MAX);

		}
	}

	public static void bfs() {
		Queue<Integer> queue= new LinkedList<Integer>();
		v = new boolean[101];
		queue.offer(start);
		v[start] = true;


		while(!queue.isEmpty()) {
			int size = queue.size();
			MAX = -1;

			// 왔을때 큐에 남아있는 수 만큼 돌아라
			for(int j=0; j<size; j++) {
				int current = queue.poll();
				MAX = Math.max(current, MAX);

				for(int i=1; i<101; i++) {
					// 아직 가보지 않았으면서, start와 연결되어있는 노드를 큐에 넣어라
					if(!v[i] && adjMatrix[current][i] != 0) {
						queue.offer(i);
						v[i] = true;
					}
				}
			}
		}
	}
}
