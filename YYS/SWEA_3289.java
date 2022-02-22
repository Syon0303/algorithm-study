import java.io.*;
import java.util.*;
public class Solution {
	
	static int n,parents[];
	static StringBuilder sb = new StringBuilder();
	
	static int find(int a) { //대표찾기
		if(parents[a]==a) return a;
		
		parents[a] = find(parents[a]); // 압축
		return parents[a];
	}
	
	static void isUnited(int a, int b) { //같으면 true
		
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {//두 집합이 같은 경우
			sb.append(1);
			return;
		}
		
		sb.append(0);
	}
	
	static void union(int a, int b) { //합치기
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return; //두 집합이 같은 경우 리턴
		
		parents[bRoot] = aRoot; // 다르면 한쪽에 합치기
	}
	
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	int T = Integer.parseInt(br.readLine());
	 for(int t=1; t<=T; t++) {
		 sb.append("#"+t+" ");
		 st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 int m = Integer.parseInt(st.nextToken());
		 
		 parents = new int[n+1];
		 
		 for(int i=0; i<n+1; i++) {
			 parents[i] = i; //자기 자신이 대표
		 }
		 
		 while(m-->0) { //m개의 입력값 받아주기
			 st = new StringTokenizer(br.readLine());
			 int command = Integer.parseInt(st.nextToken());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 
			 switch(command) { //0은 합집합, 1은 합집합 확인 연산
			 	case 0: union(a,b); break;
			 	case 1: isUnited(a, b); break;
			 }
		 }
		 
		 sb.append("\n");
	 }
	 System.out.println(sb.toString());
}
}