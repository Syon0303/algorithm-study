import java.util.Scanner;

public class BOJ_14501 {

	static int N, max;
	static int[] T, P;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N];
		P = new int[N];
		
		for(int i=0; i<N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		dfs(0, 0);
		System.out.println(max);
	}

	
	static void dfs(int idx, int sum) {
		System.out.println("today is : " + idx + "\t" + sum);
		// 종료
		if(idx >= N) {
			max = Math.max(max, sum);
			return;
		}
		
		// 만약 날짜 기준으로 일 할 수 있다면
		if(idx + T[idx] <= N) {
			// idx+날짜, sum + 오늘의 페이
			dfs(idx+T[idx], sum+P[idx]);
		}
		// 날짜가 안되면 다음 날로 ㄱㄱ
		dfs(idx+1, sum);
	}
}
