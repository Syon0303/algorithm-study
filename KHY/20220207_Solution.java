import java.util.Scanner;

public class Solution {

	static int[] s,k;
	static int N,L,sum_k,sum_s,max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N = sc.nextInt(); // 개수
			L = sc.nextInt(); // 칼로리 제한
			s = new int[N]; // 점수
			k = new int[N]; // 칼로리
			//재료 정보 입력
			for (int j = 0; j < N; j++) {
				s[j] = sc.nextInt();
				k[j] = sc.nextInt();
			}
			rec(0);
			System.out.println("#"+(i+1)+" "+max);
			max = 0;
		}
	}
	
	public static void rec(int cnt) {
		//종료 조건
		if(cnt==N) {
			if(sum_k > L) return; // 무게 초과 시 패스
			// max 값 update
			if(max < sum_s) { 
				max = sum_s;
			}
			return;
		}
		sum_k += k[cnt];
		sum_s += s[cnt];
		rec(cnt+1);
		sum_k -= k[cnt];
		sum_s -= s[cnt];
		rec(cnt+1);
	}
}
