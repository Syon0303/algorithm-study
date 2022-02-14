package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-13, 25분
 * @title 부분 수열의 합, 실버2
 */

public class BOJ_1182 {
	static StringTokenizer st;
	static int N,S;
	// 합
	static int sum = 0;
	// 카운트 ( 결과값 )
	static int res = 0;
	static int[] arr;
	static boolean[] isCheck;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		isCheck = new boolean[N];
		
		
		// 배열 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		// 다 false인  경우
		if(S == 0) {
			res--;
		}
		
		sb.append(res);
		System.out.println(sb);
	}
	
	static void dfs(int current) {
		if(current == N) {
			for(int i=0; i<N; i++) {
				if(isCheck[i]) {
					sum += arr[i];
				}
				else {
					continue;
				}
			}
			if(sum == S) {
				res++;
			}
			sum = 0;
			return;
		}
		isCheck[current] = true;
		dfs(current+1);
		
		isCheck[current] = false;
		dfs(current+1);	
	}
}
