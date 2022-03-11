import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2565_전깃줄_골드5 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr1 = new int[N+1];
		int [] arr2 = new int[N+1];
		int max=0;
		for(int i=1;i<=N;i++) {
			arr1[i] = sc.nextInt();
			arr2[i] = sc.nextInt();
			max = Math.max(max, Math.max(arr1[i],arr2[i]));
		}
		int [] arr3 = new int[max+1];
		for(int i=1;i<N+1;i++) {
			arr3[arr2[i]] = arr1[i];
		}
		Arrays.sort(arr1);
		int dp[][] = new int[arr1.length][max+1];
		for(int i=1;i<arr1.length;i++) {
			for(int j=1;j<=max;j++) {
				if(arr1[i]==arr3[j]) {
						dp[i][j]=dp[i-1][j-1]+1;
						
				}
				else dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println(N-dp[arr1.length-1][max]);
	
	}

}