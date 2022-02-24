package day15;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 적록색약, 골드 5, 40분
public class BOJ_10026 {

	static int N;
	
	static char[][] map1; // 일반 눈 맵
	static char[][] map2;// 적록색약 눈 맵
	
	static boolean[][] v1; // 일반 눈 방문
	static boolean[][] v2;// 적록색약 눈 방문
	
	static int res1;
	static int res2;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map1 = new char[N][N];
		map2 = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String s = sc.next();
			for(int j=0; j<N; j++) {
				map1[i][j] = s.charAt(j);
				// 적록색약 눈 맵에는 R과 B만 보인다. 여기서 R만 넣고 map2[i][j] = s.charAt 안해서 R만들어감 ㅋㅋ
				map2[i][j] = s.charAt(j);
				if(map2[i][j] == 'G') map2[i][j] = 'R';
			}
		}
		
		res1 = 0;
		res2 = 0;
		
		v1 = new boolean[N][N];
		v2 = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!v1[i][j]) {
					bfs1(i, j, map1[i][j]);
					res1++;
				}
				if(!v2[i][j]) {
					bfs2(i, j, map2[i][j]);
					res2++;
				}
			}
		}
		System.out.println(res1 + " " + res2);
	}
	
	public static void bfs1(int x, int y, char c) {
		Queue<Point> queue = new LinkedList<Point>();
		v1[x][y] = true;
		queue.offer(new Point(x,y));
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			for(int i=0; i<4; i++) {
				int nextX = current.x + dx[i];
				int nextY = current.y + dy[i];
				if(nextX>=0 && nextX<N && nextY>=0 && nextY<N) {
					if(!v1[nextX][nextY] && map1[nextX][nextY] == c) {
						bfs1(nextX, nextY, map1[nextX][nextY]);
					}
				}
			}
		}
	}
	
	public static void bfs2(int x, int y, char c) {
		Queue<Point> queue = new LinkedList<Point>();
		v2[x][y] = true;
		queue.offer(new Point(x,y));
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			for(int i=0; i<4; i++) {
				int nextX = current.x + dx[i];
				int nextY = current.y + dy[i];
				if(nextX>=0 && nextX<N && nextY>=0 && nextY<N) {
					if(!v2[nextX][nextY] && map2[nextX][nextY] == c) {
						bfs2(nextX, nextY, map2[nextX][nextY]);
					}
				}
			}
		}
	}
}
