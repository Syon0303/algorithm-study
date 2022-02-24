import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stn.nextToken()); // 사람 수
			int M = Integer.parseInt(stn.nextToken()); // 시간
			int K = Integer.parseInt(stn.nextToken()); // 붕어빵 수
			int arv[] = new int[N];
			stn = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arv[i] = Integer.parseInt(stn.nextToken());
			}
			Arrays.sort(arv);
			int fish = 0;
			int cnt = 0;
			boolean flag = false;
			System.out.print("#"+t+" ");
			//1초 씩 증가시키면서 붕어빵 개수 체크
			for(int i = 0; i <= arv[arv.length-1]; i++) {
				if(flag) break;
				// M 시간이 되었으면
				if(i != 0 && i % M == 0) {
  					fish += K; // 붕어빵 K개 증가
				}
				// 동시에 오는 사람 체크
				while(true) {
					// cnt 가 마지막이면 종료
  					if(cnt == N) break;
  					// cnt가 N보다 작고 손님이 왔을 때
					if(cnt < N && i == arv[cnt]) {
						// 붕어 빵이 있으면
						if(fish > 0) {
							fish--; // 1개 주고
							cnt++; // 다음 사람
						// 없으면
						}else {
							flag = true; // 반복문 종료 flag
							break;
						}
					// 현재 시간이 손님 시간보다 작으면 종료
					}else if(i < arv[cnt]) break;
				}
			}
			if(flag) {
				System.out.println("Impossible");
			}else {
				System.out.println("Possible");
			}
		}
	}
}