package defa;

import java.util.Scanner;

// OX 퀴즈, 브론즈 2, 5분
public class BOJ_8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int test_case=1; test_case<=N; test_case++) {
			String s = sc.next();
			char[] arr = s.toCharArray();
			
			int cnt = 0;
			int sum = 0;
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i]=='X') {
					cnt = 0;
					continue;
				}
				
				else if(arr[i]=='O') {
					cnt++;
					sum += cnt;
				}
			}
			System.out.println(sum);
		}
	}
}
