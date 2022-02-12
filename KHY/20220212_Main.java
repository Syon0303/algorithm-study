import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 남은 일
		int[] T = new int[N]; // 상담 기간
		int[] P = new int[N]; // 상담 금액
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] profit = new int[N+1];
		
		for (int i=0; i<N; i++) {
			// 경계 내일 경우
			if (i + T[i] <= N) {
				// 그 기간에 금액 미리 써 놓기
				// 1->4, 2->4, 3->4가 되는 경우 1,2,3중 가장 큰 값을 profit[4]에 저장
				profit[i + T[i]] = Math.max(profit[i + T[i]], profit[i] + P[i]);
			}
			//가장 마지막 값이 최대로 맞추기 위해 현재꺼를 다음꺼로 붙임
			//4->5 보다 4->6이 더 큰 경우도 있으므로 (조합)
			profit[i+1] = Math.max(profit[i+1], profit[i]);
		}
		System.out.println(profit[N]);	
	}
}