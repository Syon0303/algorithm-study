import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int C, R;
	static int map[][];
	static int dy[] = { -1, 0, 1 };
	static int res = 0;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				if (temp.toCharArray()[j]=='x') {
					map[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			fun(0, i);
		}

		System.out.println(res);
	}

	static boolean fun(int x, int y) {

		if (x == C - 1) {
			res++;
			return true;
		}

		map[y][x] = 1;

		for (int i = 0; i < 3; i++) {
			int nextX = x + 1;
			int nextY = y + dy[i];
			if (nextX < C && nextY >= 0 && nextY < R && map[nextY][nextX] != 1) {
				if (fun(nextX, nextY))
					return true;
			}
		}
		return false;
	}

}