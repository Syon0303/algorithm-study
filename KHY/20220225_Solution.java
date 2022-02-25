import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Vertex implements Comparable<Vertex>{
		int no;
		int distance;
		public Vertex(int no, int distance) {
			this.no = no;
			this.distance = distance;
		}
		@Override
		public int compareTo(Vertex o) {
			return (int) (distance - o.distance);
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케
		for (int t = 1; t <= T; t++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(stn.nextToken()); // 정점 개수
			int E = Integer.parseInt(stn.nextToken()); // 간선 개수
			ArrayList<Vertex> [] lists = new ArrayList[V+1]; // 인접 리스트
			// 인접 리스트 초기화
			for (int i = 1; i <= V; i++) {
				lists[i] = new ArrayList<Vertex>();
			}
			// map 구성
			for (int i = 0; i < E; i++) {
				stn = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(stn.nextToken());
				int to = Integer.parseInt(stn.nextToken());
				int w = Integer.parseInt(stn.nextToken());
				// 무향
				lists[from].add(new Vertex(to, w));
				lists[to].add(new Vertex(from, w));
			}
			boolean v[] = new boolean[V+1]; // 방문 체크
			PriorityQueue<Vertex> pq = new PriorityQueue<>(); // 우선순위 큐 (가중치에 따른 정렬)
			pq.offer(new Vertex(1,0)); // 초기에는 1번 정점 0거리로 offer
			long res = 0; // 결과값
			// 큐가 비어있을 때까지 수행
			while(!pq.isEmpty()) {
				Vertex cur = pq.poll(); // 큐에 있는 것 한개 poll
				if(v[cur.no]) continue; // 방문 했던 정점이면 pass
				v[cur.no] = true; // 방문 체크
				// 해당 정점에서 연결되는 정점 모두 반복
				for (Vertex next : lists[cur.no]) {
					// 연결되는 정점이 방문했던 곳이면 pass
					if(v[next.no]) continue; 
					// 방문 아니면 우선순위 큐에 offer
					pq.offer(next);
				}
				res += cur.distance; // 확정된 정점에 대해서는 결과 값 누적
			}
			// 출력
			System.out.println("#"+t+" "+res);
		}
	}
}