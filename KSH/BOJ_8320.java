package day12;

import java.util.Scanner;

// 직사각형을 만드는 방법, 브론즈2, 10분
public class BOJ_8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		
		// 가로 길이 1
		for(int i=1; i<=n; i++) {
			// 가로*세로 <= n
			for(int j=i; i*j<=n; j++) {
				res++;
			}
		}
		System.out.println(res);
	}

}
