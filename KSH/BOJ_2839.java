package day9;

import java.util.Scanner;

/*
 * BOJ_2839, 설탕 배달
 * 브론즈 1
 */
public class BOJ_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;		

		while(N>=0) {
			if(N%5==0) {
				res += N/5;
				System.out.println(res);
				break;
			}
			N -= 3;
			res++;
		}
		if(N<0) System.out.println(-1);
	}
}
