package dp;

import java.util.Scanner;

//RGB 거리, 실버 1
public class BOJ_1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		for(int i=0; i<N; i++) for(int j=0; j<3; j++) map[i][j] = sc.nextInt();
		
		for(int i=1; i<N; i++) {
			map[i][0] = Math.min(map[i-1][1], map[i-1][2]) + map[i][0];
			map[i][1] = Math.min(map[i-1][0], map[i-1][2]) + map[i][1];
			map[i][2] = Math.min(map[i-1][0], map[i-1][1]) + map[i][2];
		}
		
		int res = Integer.MAX_VALUE;
		for(int i=0; i<2; i++) if(res > map[N-1][i]) res = map[N-1][i];
		
		System.out.println(res);
	}
}
