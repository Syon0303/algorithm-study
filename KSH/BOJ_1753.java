package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로, 골드 5
public class BOJ_1753 {
	
	static class Vertex implements Comparable<Vertex> {
		int no, minDistance;
		
		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList[] arr = new ArrayList[V+1];
		
		for(int i=0; i<=V; i++) {
			arr[i] = new ArrayList<int[]>();
		}
		
		int K = Integer.parseInt(br.readLine());

		int[] distance = new int[V+1];
		boolean[] v = new boolean[V+1];

		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		
		Arrays.fill(distance, 987654321);
		distance[K] = 0;
		pQueue.offer(new Vertex(K, distance[K]));
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[from].add(new Vertex(to, weight));
		}		
		
		while(!pQueue.isEmpty()) {
			Vertex current = pQueue.poll();
			
			if(v[current.no]) continue;
			v[current.no] = true;
			
			for(int i=0; i<arr[current.no].size(); i++) {
				Vertex temp = (Vertex) arr[current.no].get(i);
				if(!v[temp.no] && distance[temp.no] > temp.minDistance + distance[current.no]) {
					distance[temp.no] = temp.minDistance + distance[current.no];
					pQueue.offer(new Vertex(temp.no, distance[temp.no]));
				}
			}
		}
		for(int i=1; i<=V; i++) {
			if(distance[i] == 987654321) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
}
