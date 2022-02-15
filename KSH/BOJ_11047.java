package day9;

import java.util.Scanner;

/*
 * BOJ_11047, 동전 0
 * 실버 3
 */
public class BOJ_11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전의 종류 수
		int K = sc.nextInt(); // 아래 동전으로 이 가격을 만들어야 함
		int[] map = new int[N];
		for(int i=0; i<N; i++) map[i] = sc.nextInt();

		int res = 0;
		for(int i=N-1; i>=0; i--){
			if(map[i] <= K) {
				res += K/map[i];
				K %= map[i];
			}
		}
		System.out.println(res);
	}
}
