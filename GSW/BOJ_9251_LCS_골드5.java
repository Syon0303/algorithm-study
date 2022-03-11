import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_9251_LCS_골드5 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char [] arr1 = sc.nextLine().toCharArray();
		char [] arr2 = sc.nextLine().toCharArray();
		int max=1;
		int dp[][] = new int[arr1.length+1][arr2.length+1];
		for(int i=1;i<arr1.length+1;i++) {
			for(int j=1;j<arr2.length+1;j++) {
				if(arr1[i-1]==arr2[j-1]) {
						dp[i][j]=dp[i-1][j-1]+1;
						
				}
				else dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println(dp[arr1.length][arr2.length]);
	
	}

}