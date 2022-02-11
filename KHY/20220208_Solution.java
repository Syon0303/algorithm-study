import java.util.Scanner;

public class Solution {
	
	static int N, M, sum[], a[], max = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1; i<=T; i++) {
			N = sc.nextInt(); //과자 봉지 개수
			M = sc.nextInt(); // 무게 합 제한
			a = new int[N];
			sum = new int[N];
			// 과자 무게 입력
			for(int j=0; j<N; j++) {
				a[j] = sc.nextInt();
			}
			// 조합 재귀 시작
			Combination(0, 0);
			System.out.println("#"+i+" "+max);
			max = -1; // max값 초기화
		}
	}
	
	public static void Combination(int cnt, int st) {
		if(cnt == 2) {
			int res = sum[0] + sum[1];
			if(res > M) return;
			max = Math.max(res, max);
			return;
		}
		
		for(int i=st; i<N; i++) {
			sum[cnt] = a[i];
			Combination(cnt+1, i+1);
		}
	}
}