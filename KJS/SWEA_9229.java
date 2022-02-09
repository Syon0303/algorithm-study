package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author us13579
 * @since 2022-02-08, 15분
 * @title 한빈이와 Spot Mart (D3)
 */

public class SWEA_9229 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int T = 1; T <= tc; T++) {
			sb.append("#").append(T).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max = 0;
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++)
				for(int j=i+1; j<N; j++) {
					int sum = arr[i]+arr[j];
					if(sum>M) {
						continue;
					}
					else {
					max = Math.max(max, sum);
					}
				}
			if(max == 0) {
				max = -1;
			}
			sb.append(max);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
