import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[][] dp = new long[31][31];
		
		//nCm-1 + nCm = n+1Cm-1
		for(int i=1; i<31; i++) {
			dp[i][0]=1;
			dp[i][i]=1;
			for(int j=1; j<i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		while(T-->0) {
			int M = sc.nextInt();
			int N = sc.nextInt(); //편의상 큰수가 N	
			System.out.println(dp[N][M]);
		}
}
}