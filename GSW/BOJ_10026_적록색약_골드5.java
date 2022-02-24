import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class BOJ_10026_적록색약_골드5 {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int N;
	static char map[][];
	static boolean check[][];
	static boolean check2[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		int res = 0;
		int res2 = 0;
		map = new char[N][N];
		check = new boolean[N][N];
		check2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					dfs2(j, i);
					res++;
				}
				if (!check2[i][j]) {
					dfs(j, i);
					res2++;
				}
			}
		}
		System.out.printf("%d %d", res, res2);

	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				continue;
			}
			if (check2[nextY][nextX]) {
				continue;
			}
			if (map[y][x] == 'B') {
				if (map[y][x] != map[nextY][nextX]) {
					continue;
				}
			} else if (map[nextY][nextX] == 'B') {
				continue;
			}
			check2[nextY][nextX] = true;
			dfs(nextX, nextY);
		}
	}

	static void dfs2(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				continue;
			}
			if (check[nextY][nextX]) {
				continue;
			}

			if (map[y][x] != map[nextY][nextX]) {
				continue;
			}

			check[nextY][nextX] = true;
			dfs2(nextX, nextY);
		}
	}
}