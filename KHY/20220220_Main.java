import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int max = 0, maxidx = 0;
		int rmax = 0, rmaxidx = 0;
		boolean[] visited = new boolean[L+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(stn.nextToken());
			int K = Integer.parseInt(stn.nextToken());
			// 가장 많은 조각을 받을 것으로 기대하는 방청객 찾기
			if(max < K-P) {
				max = K-P;
				maxidx = i;
			}
			int real = 0;
			// 실제로 많은 조각을 받은 방청객 찾기
			for (int j = P; j <= K; j++) {
				if(visited[j]) continue;
				real++;
				visited[j] = true;
			}
			if(rmax < real) {
				rmax = real;
				rmaxidx = i;
			}
		}
		System.out.println(maxidx);
		System.out.println(rmaxidx);
	}
}