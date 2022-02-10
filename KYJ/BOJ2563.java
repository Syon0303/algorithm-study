import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[100][100]; // 도화지
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					if(!map[j][k]) { // false 이면
						map[j][k] = true;
						cnt++;
					}
				}
			}
			
		}
		
		System.out.println(cnt);
	}
}
