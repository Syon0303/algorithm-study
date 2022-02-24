import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
   
    static class Edge implements Comparable<Edge>{
    	int vertex, cost;

		public Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
    }
    
    static int V,E,K;
    static int from,to,w;
    static int [] distance;
    static ArrayList[] adjList;
        
    public static void main(String[] args) throws Exception  {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stn.nextToken());
        E = Integer.parseInt(stn.nextToken());
        K = Integer.parseInt(br.readLine());
        
        // 거리배열 무한대로 초기화
        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        // 인접리스트 초기화 (adjList[1].get(2) = 1번 정점에서 2번째로 들어있는 Edge정보)
        adjList = new ArrayList[V+1];
        for (int i=1; i<=V; i++) {
        	adjList[i] = new ArrayList<Edge>();
        }
        
        // 방향간선 인접리스트 입력
        for (int i=1; i<=E; i++) {
        	stn = new StringTokenizer(br.readLine());
        	from = Integer.parseInt(stn.nextToken());
        	to = Integer.parseInt(stn.nextToken());
        	w = Integer.parseInt(stn.nextToken());
        	adjList[from].add(new Edge(to,w)); 
        }
        
        // 출발지부터 다익스트라 시작
        dijkstra(K);
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=V; i++) {
        	if (distance[i] == Integer.MAX_VALUE) {
        		sb.append("INF\n");
        	}
        	else {
        		sb.append(distance[i]+"\n");
        	}
        }
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
        br.close();
    }    

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); // 우선순위 큐
        distance[start] = 0; // 시작 지점 0으로 초기화
        pq.add(new Edge(start,0)); // 첫 시작 정점 pq에 넣고 시작
        // 큐가 비어 있을 때까지 반복
        while(!pq.isEmpty()) {
        	Edge cur = pq.poll();
        	if (cur.cost > distance[cur.vertex]) continue;
        	int len = adjList[cur.vertex].size(); // 현재 정점에서 이동 가능한 경로 수
        	for (int i = 0; i<len; i++) {
        		Edge next = (Edge) adjList[cur.vertex].get(i); // 현재 정점에서 이동 가능한 다음 정점
        		// 다음 정점까지 직통 했던 거리보다 현재 정점을 경유해서 가는 것이 더 최단이라면 업데이트 
        		if (distance[next.vertex] > cur.cost + next.cost ) {
        			distance[next.vertex] = cur.cost + next.cost;
        			pq.add(new Edge(next.vertex, distance[next.vertex])); // 다음 정점 우선순위 큐에 넣기 (최단이므로)
        		}
        	}
        	
        }
    }
}