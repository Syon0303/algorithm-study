package day14;

import java.util.HashSet;
import java.util.Scanner;

// 창용 마을 무리의 개수 / D4 / 1시간
public class SEA_7465 {
	
	static int T, N, M;
	static int p[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			makeSet();			
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				unionSet(a, b);
			}
			
			HashSet<Integer> hs = new HashSet<>();
			for(int i=0; i<N+1; i++) {
				hs.add(findSet(i));
			}
			System.out.println("#" + t + " " + hs.size());
		}
	}
	
	static boolean unionSet(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a==b) return false;
		p[b] = a;
		return true;
	}
	
	static int findSet(int a) {
		if(a == p[a]) return a;
		p[a] = findSet(p[a]);
		return p[a];
	}
	
	public static void makeSet() {
		p = new int[N+1];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
	}
}
