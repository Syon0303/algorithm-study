package day14;

import java.util.Scanner;
// 색종이, 브론즈 1, 10분
public class BOJ_10163 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int[][] map = new int[1001][1001];
		int N = sc.nextInt();

		for(int n=1; n<=N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();

			for(int i=x; i<x+w; i++) {
				for(int j=y; j<y+h; j++) {
					map[i][j] = n;
				}
			}
		}

		for(int k=1; k<=N; k++) {
			int res = 0;
			for(int i=0; i<1001; i++) {
				for(int j=0; j<1001; j++) {
					if(map[i][j]==k) res++;
				}
			}
			System.out.println(res);
		}
	}
}
