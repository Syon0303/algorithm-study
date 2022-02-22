import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		for (int i = 0; i < N; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stn.nextToken());
			int y = Integer.parseInt(stn.nextToken());
			int c = Integer.parseInt(stn.nextToken()); // 가로 길이
			int r = Integer.parseInt(stn.nextToken()); // 세로 길이
			for (int k = y; k < y+r; k++) {
				for (int j = x; j < x+c; j++) {
					map[k][j] = i+1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int res = 0;
			for (int k = 0; k < 101; k++) {
				for (int j = 0; j < 101; j++) {
					if(map[k][j] == i+1) {
						res++;
					}
				}
			}
			System.out.println(res);
		}
	}
}