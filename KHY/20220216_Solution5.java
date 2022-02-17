import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static int n, r, S[][], min = Integer.MAX_VALUE;
	static LinkedList<Integer> A = new LinkedList<Integer>();
	static LinkedList<Integer> B = new LinkedList<Integer>();	
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			n = N-1; // 본인을 제외한 것 중에서
			r = (N/2)-1; // 절반 - 1(본인) 뽑기
			visited = new boolean[N];
			S = new int[N][N]; // 시너지
			// 입력
			for (int j = 0; j < S.length; j++) {
				StringTokenizer stn = new StringTokenizer(br.readLine());
				for (int k = 0; k < S[j].length; k++) {
					S[j][k] = Integer.parseInt(stn.nextToken());
				}
			}
			A.add(0);
			combination(0, 0);
			System.out.println("#"+i+" "+min);
			min = Integer.MAX_VALUE;
			A.clear(); B.clear();
		}
	}
	//(n-1)C(n/2-1)
	public static void combination(int cnt, int start) {
		// 음식 조합이 정해졌으면
		if(cnt == r) {
			// B 음식 재료 = A 음식에서 선택 안된 것
			B.clear();
			for (int i = 1; i < n+1; i++) {
				if(visited[i]) continue;
				B.add(i);
			}
			int a = 0, b = 0;
			// A 음식 B 음식의 시너지 합 구하기
			for (int i = 0; i < r+1; i++) {
				for (int j = i+1; j < r+1; j++) {
					a += sum(A.get(i), A.get(j));
					b += sum(B.get(i), B.get(j));
				}
			}
			// 최소 차이 구하기
			min = Math.min(Math.abs(a-b), min);
			return;
		}
		for (int i = start; i < n; i++) {
			A.addLast(i+1);
			visited[i+1] = true;
			combination(cnt+1, i+1);
			A.removeLast();
			visited[i+1] = false;
		}
	}
	// 시너지 합 구하는 함수
	public static int sum(int i, int j) {
		return S[i][j] + S[j][i];
	}
}