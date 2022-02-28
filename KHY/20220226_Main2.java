import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			StringTokenizer stn = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(stn.nextToken());
			}
			int res = 0;
			int max = price[N-1]; // 마지막 날 부터 시작
			for (int i = N-2; i >= 0; i--) {
				// 전날이 가격이 더 낮으면 
				if(max > price[i]) {
					res += max - price[i]; // 차액만큼 추가
				// 전날이 가격이 더 높으면
				}else if(max < price[i]) {
					max = price[i]; // max 값 바꾸기
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}