import java.io.*;
import java.util.*;

public class Solution {
	static int[] parents;
	static int find(int a) { //유니온 파인드 대표값 찾기 메서드
		if(parents[a] == a) return a;
		parents[a] = find(parents[a]);
		return parents[a];
	}
	static boolean union(long arr, long arr2) { //합치기 가능하면 true
		int aRoot = find((int)arr);
		int bRoot = find((int)arr2);
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		return true;
	}
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int T = Integer.parseInt(br.readLine());
	for (int t = 1; t <= T; t++) {
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		for(int i=0; i<=V; i++) { // 각각의 부분집합 생성
			parents[i] = i;
		}
		long[][] arr = new long[E][3];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long C = Long.parseLong(st.nextToken());
			arr[i][0] = C;
			arr[i][1] = A;
			arr[i][2] = B;
		}
		Arrays.sort(arr,new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				// TODO Auto-generated method stub
				return Long.compare(o1[0], o2[0]);
			}
		});
		long res = 0;
		for(int i=0; i<E; i++) {
			if(union(arr[i][1],arr[i][2])) { //합이 가능하면 합쳐주고
				res += arr[i][0];
			}
		}
		System.out.println("#"+t+" "+res);
	}
	
}
}