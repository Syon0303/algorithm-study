import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cards[], arr[], max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stn.nextToken());
		M = Integer.parseInt(stn.nextToken());
		cards = new int[N];
		arr = new int[3];
		stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(stn.nextToken());
		}
		combination(0, 0);
		System.out.println(max);
	}
	public static void combination(int cnt, int start) {
		if(cnt == 3) {
			int sum =0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			if(sum <= M) {
				max = Math.max(sum, max);
			}
			return;
		}
		for (int i = start; i < cards.length; i++) {
			arr[cnt] = cards[i];
			combination(cnt+1, i+1);
		}
	}
}