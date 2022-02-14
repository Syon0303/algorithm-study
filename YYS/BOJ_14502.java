import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+2];
		int MAX = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i-1; j++) { //이전항까지의 최대값과 비교해 더 큰 값 사용
				dp[i] = Math.max(dp[i], dp[j]);
			}
			int last_day = sc.nextInt()+i; //상담이 끝나고 돈을 받은 다음날
			int P = sc.nextInt(); //금액
			
			if(last_day>N+1) continue; // 경계값을 벗어나면 기록X
			
			// 각 날짜에 벌 수 있는 최대값을 기록해줍니다
			
			dp[last_day] = Math.max(dp[i]+P, dp[last_day]);
		}
        //N까지는 최대값이 갱신되지만 N+1은 따로 해줘야합니다.
		System.out.println(Math.max(dp[N], dp[N+1]));
}
}