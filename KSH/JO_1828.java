package day10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 * 냉장고
 */
public class JO_1828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][2];
		for(int i=0; i<N; i++) for(int j=0; j<2; j++) map[i][j] = sc.nextInt();


		// 최대 온도를 기준으로 정렬 (오름차순으로)
		Arrays.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		int max = map[0][1];
		int cnt = 1; // 냉장고는 무조건 한대부터 시작
		
		// i번째 최저 온도보다 max가 크거나 같고 최대 온도보다 max가 크면 max = map[i][1];
		for(int i=0; i<N; i++) {
			if(map[i][0] <= max) {
				if(map[i][1] < max) {
					max = map[i][1];
				}
				continue; // i번째 최대 온도보다 max가 작으면 다음 화학물질 보러감
			}
			// 이번 재료의 최대 온도가 max보다 크다면 max 변경 후 cnt++
			else {
				max = map[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
