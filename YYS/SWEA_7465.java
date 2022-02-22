import java.io.*;
import java.util.*;
public class Solution {
	static int[] parents;
	
	static int find(int a) { //find 메서드입니다
		if(parents[a]==a) return a; //대표값을 반환합니다
		
		parents[a] = find(parents[a]); //경로 압축 + 부모노드 거슬러 올라가기
		
		return parents[a];
	}
	
	static void union(int a, int b) { // union 메서드
		int aRoot = find(a); //대표값을 구하고
		int bRoot = find(b);
		if(aRoot == bRoot) return; //같다면 합치지 않고
		
		parents[aRoot] = bRoot; //다르다면 합칩니다
	}
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	int T = Integer.parseInt(br.readLine()); //정점 개수
	
	for(int t=1; t<=T; t++) {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		
		for(int i=0; i<N+1; i++) { //자기 자신이 집합의 대표
			parents[i] = i;
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b); // a와 b원소가 속한 집합을 합쳐줍니다
		}
		int cnt = 0; //개수를 세어줄 변수
		
		for(int i=1; i<N+1; i++) { // 대표의 개수가 곧 무리의 개수
			if(parents[i]==i) cnt++;
		}
		System.out.println("#"+t+" "+cnt);
	}
	 
}
}