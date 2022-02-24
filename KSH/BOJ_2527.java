package day15;

import java.util.Scanner;

// 직사각형, 실버 1, 30분
public class BOJ_2527 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 4;
		for(int test_case=1; test_case<=T; test_case++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();

			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();

			if((x1>p2||x2>p1)||(y1>q2)||(q1<y2)) {
				System.out.println("d");
			}else if((x1==p2||x2==p1)&&(y1==q2)||(q1==y2)) {
				System.out.println("c");
			}else if((x1==p2||x2==p1)||(y1==q2)||(q1==y2)) {
				System.out.println("b");
			}else {
				System.out.println("a");
			}
		}
	}
}
