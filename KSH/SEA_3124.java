package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//최소 스패닝 트리, D4, Kruskal 알고리즘, 20분
public class SEA_3124 {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int N;
	static int[] p;
	static Edge[] edgeList;

	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) {
			return false;
		}

		p[bRoot] = aRoot; 
		return true;
	}
	

	static int findSet(int a) {
		if(a == p[a]) {
			return a;
		}
		p[a] = findSet(p[a]); //경로 압축;
		return p[a]; // 현재 위치의 부모값 반환
	}

	
	static void makeSet() {
		p = new int[N]; //부모를 관리하는 배열
		//자신의 부모노드를 자신으로 설정
		for(int i =0; i < N; i++) {
			p[i] = i;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList); // 간선 비용의 오름차순
		makeSet();
		
		long result = 0;
		int cnt = 0;
		
		for(Edge edge : edgeList) {
			if(unionSet(edge.from, edge.to)) {
				result += edge.weight;
				cnt++;
				if(cnt == N-1) break;
			}
		}
		
		System.out.println("#" + test_case + " " + result);
	}
}
