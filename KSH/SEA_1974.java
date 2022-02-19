package day12;

import java.util.Scanner;

/*
 * 스도쿠 검증
 * 반복문 및 검증을 위한 v(visited) 배열 사용
 */
public class SEA_1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {

			int[][] map = new int[9][9];
			for(int i=0; i<9; i++) for(int j=0; j<9; j++) map[i][j] = sc.nextInt();
			boolean flag = true;
			
			for(int i=0; i<9; i++) {
				int[] rV = new int[9];
				int[] cV = new int[9];
				for(int j=0; j<9; j++) {
					rV[(map[i][j]-1)]++;
					cV[(map[j][i]-1)]++;
				}
				for(int j=0; j<9; j++) {
					if(rV[j] == 0 || cV[j] == 0) {
						flag = false;
						break;
					}
				}
			}
			
			for(int i=0; i<=6; i+=3) {
				for(int j=0; j<=6; j+=3) {
					int[] v = new int[9];
					for(int k=i; k<i+3; k++) {
						for(int w=j; w<j+3; w++) {
						v[map[k][w]-1]++;
						}
					}
					for(int k=0; k<9; k++) {
						if(v[k] == 0) {
							flag = false;
							break;
						}
					}
				}
			}
			
			if(flag) System.out.println("#" + test_case + " " + 1);
			else System.out.println("#" + test_case + " " + 0);
		}
	}
}
