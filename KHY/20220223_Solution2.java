import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stn.nextToken()); // 마을 수
			int d = Integer.parseInt(stn.nextToken()); // 거리
			stn = new StringTokenizer(br.readLine());
			int res = 0;
			int idx = d-1; // idx
			for (int j = 0; j < n; j+=d) {
				boolean flag = false;
				int temp = idx;
				for (int l = 0; l < d; l++) {
					if(stn.hasMoreTokens()) {
						if(stn.nextToken().equals("1")) {
							temp = l;
							flag = true;
						}
						if(l==idx && !flag) {
							res++;
						}
					}
				}
				idx = temp;
			}
			System.out.println("#"+i+" "+res);
		}
	}
}