import java.util.Arrays;
import java.util.Scanner;

public class SEA_3124_최소스패닝트리_D4 {
	static Edge[] list;
	static int p[];
	static int N;
	public static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			super();
			this.end = end;
			this.start = start;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 1; t <= testCase; t++) {
			////////////////////////////
			N = sc.nextInt();
			int E = sc.nextInt();
			list = new Edge[E];
			for (int i = 0; i < E; i++) {
				list[i] = new Edge(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt());
			}
			Arrays.sort(list);
			
			makeSet();
			long res=0;
			int cnt=0;
			for(Edge e :list) {
				if(unionSet(e.start,e.end)) res+=e.weight;
				if(cnt==N-1) break;
			}
			System.out.printf("#%d %d%n",t,res);
			///////////////////////
		}

	}
	
	
	
	
	
	 static boolean unionSet(int a, int b) {
	        a = findSet(a);
	        b = findSet(b);
	        if(a == b) {
	            return false;
	        }
	        p[b] = a; 
	        return true;
	    }
	
	static void makeSet() {
        p = new int[N]; //부모를 관리하는 배열
        //자신의 부모노드를 자신으로 설정
        for(int i =0; i < N; i++) {
            p[i] = i;
        }
    }
	static int findSet(int a) {
        if(a == p[a]) {  // a => 3 ,p[a] = 5;
            return a;
        }
        p[a] = findSet(p[a]); //경로 압축;
        return p[a]; // 현재 위치의 부모값 반환
    }
	
}
