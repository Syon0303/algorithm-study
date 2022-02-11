import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N = 0, M = 0, cnt = 0, visited[], mat[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 노드 개수
		M = Integer.parseInt(br.readLine()); // 간선 개수
		mat = new int[N + 1][N + 1]; // 간선 정보
		visited = new int[N + 1]; // 노드 방문 정보
		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			mat[a][b] = 1;
		}
		// node 1부터 방문
		bfs();
		if(cnt == 0) System.out.println(0);
		else System.out.println(cnt-1); // 1 제외 계산
		br.close();
	}

	public static void bfs() {
		int current = 1;
		Queue<Integer> queue = new LinkedList<Integer>(); // 간선에 연결된 노드 저장하기 위한 노드
		while (true) {
			// 방문 했던 곳이면
			if(visited[current] == 1) {
				// 큐가 비어있으면 끝
				if(queue.isEmpty()) break;
				// 큐가 남아있으면 다음 노드 방문
				current = queue.poll();
				continue;
			}
			// 현재 노드에 연결된 노드 찾기
			for (int i = 1; i <= N; i++) {
				if (i != current && (mat[current][i] == 1 || mat[i][current] == 1)) {
					queue.offer(i);
				}
			}
			// 큐가 비어 있으면
			cnt++;
			if(queue.isEmpty()) {
				break;
			}else {
				// 연결된 노드 있으면 방문
				visited[current] = 1; // 방문 정보 update
				current = queue.poll();
			}
		}
	}
}