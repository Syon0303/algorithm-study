import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int N;
	static int [] p;
	
	public static int findSet(int x) {
		if(x==p[x]) return x;
		return p[x] = findSet(p[x]);
	}
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
		
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int t = 1; t <= testCase; t++) {
			////////////////////////////
			Set <Integer> set = new HashSet<Integer>();
			N = sc.nextInt();
			int M = sc.nextInt();
			p = new int [N];
			for(int i=0;i<N;i++) {
				p[i] = i;
			}
			for(int i=0;i<M;i++) {
				union(sc.nextInt()-1,sc.nextInt()-1);
			}
			for(int i=0;i<p.length;i++) {
				findSet(i);
			}
			for(int i=0;i<p.length;i++) {
				set.add(p[i]);
			}
			System.out.printf("#%d %d\n",t,set.size());
			///////////////////////
		}

	}
}
