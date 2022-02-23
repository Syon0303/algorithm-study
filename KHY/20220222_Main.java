import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	stn = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stn.nextToken());
		int K = Integer.parseInt(stn.nextToken());
		int[][] map = new int[2][7];
		for (int i = 0; i < N; i++) {
			stn = new StringTokenizer(br.readLine());
			map[Integer.parseInt(stn.nextToken())][Integer.parseInt(stn.nextToken())]++;
		}
		int res = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				if(map[i][j] != 0) {
					res += (int)Math.ceil(1.0 * map[i][j] / K);
				}
			}
		}
		System.out.println(res);
	}
}