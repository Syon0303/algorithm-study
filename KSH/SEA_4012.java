package day10;

import java.util.Scanner;

/*
 * 수업시간
 * [모의 SW 역량테스트] 요리사
 */
public class SEA_4012 {

	static int[][] map;
	static int N;
	static boolean[] v;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			for(int i=0; i<N; i++) for(int j=0; j<N; j++) map[i][j] = sc.nextInt();
			
			int res = Integer.MAX_VALUE; // 최소 값을 구하여라
			// 1. 부분집합
			// 2. N/2 체크
			// 3. 각각의 합
			// 4. 값 차이
			// 5. 최소값

			int size = 1<<N; // 부분 집합의 총 갯수
			// 000 111 = 111 000이므로 반만 해도 된다. size를 반으로 줄이자.
			size /= 2;
			for(int flag = 1; flag < size; flag++) {
				// 현재 숫자가 2등분 되었는지 cnt
				// 2. N/2 체크
				int cnt = 0;
				boolean[] v = new boolean[N];
				for(int i=0; i<N; i++) {
					if((flag & (1<<i)) != 0) {
						cnt++;
						v[i] = true;
					}
				}
				// 현재 숫자가 2등분 되었나?
				// 3. 각각의 합
				if(cnt == N/2) {
					int sumA = 0;
					int sumB = 0;
					for(int i=0; i<N; i++) {
						for(int j=0; j<N; j++) {
							if(i==j) continue;
							
							if(v[i] != v[j]) continue;
							
							// 같은 식재료들의 합 구하기
							if(v[i]) { // A음식이다.
								sumA += map[i][j];
							}else { // B음식이다.
								sumB += map[i][j];
							}
						}
					}
					// 4. 값 차이
					int ch = Math.abs(sumA-sumB);
					// 5. 최소값
					res = Math.min(ch, res);
				}
			}		
			System.out.println("#" + test_case + " " + res);
		}
	}
}
