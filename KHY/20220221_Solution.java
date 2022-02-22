import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, V, max, res, level[];
	static boolean visited[], map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			N = (Integer.parseInt(stn.nextToken()))/2; // 길이
			V = Integer.parseInt(stn.nextToken()); // 시작점
			map = new boolean[101][101]; // 인접 행렬
			visited = new boolean[101]; // 방문 체크
			level = new int[101]; // bfs level
			stn = new StringTokenizer(br.readLine());
			// 인접 행렬 입력 받기
			for (int j = 0; j < N; j++) {
				int from = Integer.parseInt(stn.nextToken());
				int to = Integer.parseInt(stn.nextToken());
				map[from][to] = true;
			}
			bfs(V);
			System.out.println("#"+i+" "+res);
			max = 0;
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start); // 시작 노드 큐에 offer
		visited[start] = true; // 방문 체크
		// 큐가 비어 있을 때까지 반복
		while(!queue.isEmpty()) {
			int current = queue.poll();
			visited[current] = true;
			for (int i = 1; i < 101; i++) {
				// 방문하지 않고 연결된 간선이 있으면
				if((!visited[i]) && map[current][i]) {
					visited[i] = true; // 방문체크
					queue.offer(i); // 큐에 offer
					level[i] = level[current] + 1; // 현재 레벨 + 1
				}
			}
			// max level보다 현재 레벨이 높으면
			if(level[current] > max) {
				max = level[current]; // max level 바꿔주고
				res = current; // 높은 레벨 값으로 대체
			}
			// 레벨 값이 같으면
			if(level[current] == max) {
				res = Math.max(res, current); // 크기 비교
			}
		}
	}
}