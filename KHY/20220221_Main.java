import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String m = br.readLine(); // 문자열
		int n = m.length(); // 문자열 길이
		int R = 0, C = 0;
		// 행렬 크기 찾기
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if(i * j == n) {
					R = i;
					C = j;
				}
			}
		}
		char[] mm = m.toCharArray();
		char[][] map = new char[R][C];
		int cnt = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				map[j][i] = mm[cnt];
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
		}
		System.out.println(sb);
	}
}