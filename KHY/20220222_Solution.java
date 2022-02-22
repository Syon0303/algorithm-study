import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, P[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			System.out.print("#"+i+" ");
			StringTokenizer stn = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stn.nextToken());
			makeSet();
			int m = Integer.parseInt(stn.nextToken());
			for (int j = 0; j < m; j++) {
				stn = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stn.nextToken());
				int b = Integer.parseInt(stn.nextToken());
				unionSet(a, b);
			}
			boolean[] arr = new boolean[N+1];
			int cnt = 0;
			// 대표자 수 세서 그룹 세기
			for (int j = 1; j <= N; j++) {
				if(!arr[findSet(j)]) {
					arr[findSet(j)] = true;
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	// 서로소 합치기
	public static boolean unionSet(int a, int b) {
		int aroot = findSet(a);
		int broot = findSet(b);
		// 대표자 같으면 이미 속해 있음
		if(aroot == broot) {
			return false;
		}
		// 다르면 합치기 (b 대표자를 a 대표자로)
		P[broot] = aroot;
		return true;
	}
	// 대표자 찾기
	public static int findSet(int a) {
		// 본인을 가리키면 대표자
		if(a == P[a]) {
			return a;
		}
		// 본인이 아니면 거슬러 올라가기
		P[a] = findSet(P[a]);
		return P[a];
	}
	// 하나의 원소 집합 만들기
	public static void makeSet() {
		P = new int[N+1];
		for (int i = 1; i <= N; i++) {
			P[i] = i;
		}
	}
}