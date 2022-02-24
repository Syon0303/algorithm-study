import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int tmp = 0;
			int idx = 1;
			int now = 0; //현재 붕어빵의 개수
			boolean judge = true;
			for(int i=0; i<=arr[N];i++) {
				if(tmp==M) {
					tmp = 0;
					now+=K;
				}
				if(arr[idx]==i && now==0) {
					judge = false;
					i = 999999;
				}else if(arr[idx]==i && now>0){
					idx++; //다음 손님 대기
					now--; //붕어빵 주기
				}
				tmp++;
			}
			System.out.print("#"+t+" ");
			System.out.println(judge?"Possible":"Impossible");
		}
	}

}