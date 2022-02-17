package day10;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 스터디
 * ATM / 실버 3
 */
public class BOJ_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] map = new int[N];
		for(int i=0; i<N; i++) map[i] = sc.nextInt();
		
		// 돈을 뽑는 시간이 가장 짧은 사람부터 뽑아야 시간의 합이 최소가 된다.
		Arrays.sort(map);
		
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			sum = sum + map[i] * (N-i);
		}
		
		System.out.println(sum);
	}
}
