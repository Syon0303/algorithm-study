import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_가장긴증가하는부분수열_실버2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		int [] dp = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			dp[i] =1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]&&dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			max=Math.max(max,dp[i]);
		}
		System.out.println(max);
	}

}