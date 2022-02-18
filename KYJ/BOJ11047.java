import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		int coins[] = new int[N];
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		for(int i = N-1; i >= 0; i--) {
			if(coins[i] > K) continue;
			cnt += K/coins[i];
			K %= coins[i];
		}
		System.out.println(cnt);
	}
}
