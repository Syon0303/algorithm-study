package dp;
import java.util.Arrays;
import java.util.Scanner;

// 01타일, 실버 3
public class BOJ_1904 {
	
	final static int MY_MAX = 1000001;
	final static int MY_DEFAULT = -1;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp = new int[MY_MAX];
		Arrays.fill(dp, MY_DEFAULT);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		int res = func(N);
		System.out.println(res);
	}
	
	public static int func(int N) {
		if(dp[N] == MY_DEFAULT) dp[N] = (func(N-1) + func(N-2)) % 15746;
		return dp[N];
	}
}
