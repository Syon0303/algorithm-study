package day6;

import java.util.Scanner;

public class BOJ_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					map[j][k] = 1;
				}
			}
		}

		for(int i[] : map) {
			for(int j : i) {
//				System.out.print(j);
				sum += j;
			}
		}
		System.out.println(sum);
	}

}
