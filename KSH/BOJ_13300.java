package day14;

import java.util.Scanner;

// 방 배정, 브론즈 2, 20분
public class BOJ_13300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt(); // 한 방에 배정할 수 있는 최대 인원 수
		
		// map[grade][gender]
		int[][] map = new int[6][2];
		
		for(int i=0; i<N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			map[grade-1][gender]++;
		}
		
		int res = 0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				if(map[i][j]==0) continue;
				if(map[i][j]%K==0) res += map[i][j]/K;
				else res += map[i][j]/K +1;
			}
		}
		System.out.println(res);
	}

}
