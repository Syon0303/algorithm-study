import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Queue;

public class BOJ_1753_최단경로_골드5 {
	static class Vertex implements Comparable<Vertex>{
		int v;
		int minCost;
		Vertex(int v, int minCost){
			super();
			this.v = v;
			this.minCost = minCost;
		}
		
		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.minCost-o.minCost;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList[] map = new ArrayList[V];
		for(int i=0;i<V;i++) {
			map[i] = new ArrayList<Vertex>();
		}
		//int[][] map = new int[V][V];
		int start = Integer.parseInt(br.readLine())-1;
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken())-1;
			int u = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			map[v].add(new Vertex(u,w));
		}
		
		int [] cost = new int[V];
		//boolean [] visited = new boolean[V];
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;
		pq.offer(new Vertex(start,cost[start]));
		
		while(!pq.isEmpty()) {
			
			Vertex cur = pq.poll();
			
			//visited[cur.v] = true;
			int len = map[cur.v].size();
			for(int j=0;j<len;j++) {
				//if(visited[j]) continue;
				Vertex temp = (Vertex) map[cur.v].get(j);
				if(cost[temp.v]>cost[cur.v]+temp.minCost) {
					cost[temp.v] = cost[cur.v]+temp.minCost;
					pq.offer(new Vertex(temp.v,cost[temp.v]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : cost) {
			if(i == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(i+"\n");
		}
		System.out.println(sb.toString());
		
	
	}
}