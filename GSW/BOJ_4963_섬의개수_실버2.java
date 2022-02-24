import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class BOJ_4963_섬의개수_실버2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int [][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		

		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			int[][] map = new int[h][w];
			int res = 0;
			Queue<int[]> queue = new LinkedList<int[]>();
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						res++;
						queue.offer(new int[] { i, j });

						while (!queue.isEmpty()) {
							int[] temp = queue.poll();
							for(int k=0;k<8;k++) {
								int dy = temp[0]+d[k][0];
								int dx = temp[1]+d[k][1];
								if(dx>=0&&dx<w&&dy>=0&&dy<h&&map[dy][dx]==1) {
									map[dy][dx] = 0;
									queue.offer(new int [] {dy,dx});
								}
							}
						}

					}
				}
			}
			System.out.println(res);
		}

	}

}