package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-12, 45분
 * @title 퇴사, 실버3
 */

public class BOJ_14501{
	static StringTokenizer st;
	static int N;
	static int[][] arr;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			// [0] = 기간 , [1] = 금액
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		dfs(0,0);
		sb.append(max);
		System.out.println(max);
	}
	
	static void dfs(int day,int money) {
		
		// 기저조건 : 기간을 초과하는 경우
		if(day >= N) {
			max = Math.max(max, money);
			return;
		}
		
		for(int i=day; i<N; i++) {
			// 기간을 초과하지 않는 경우 - 금액 더 해주고 걸리는 기간 더해서 넘긴다
			if(i+arr[i][0] <= N) {
				dfs(i+arr[i][0], money+arr[i][1]);
			}
			// 기간을 초과하는 경우 - 금액은 더 해주지않고 기간 더해서 넘긴다 -> 기저조건
			else{
				dfs(i+arr[i][0], money);
			}
		}
	}
}