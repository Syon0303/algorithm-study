package defa;

import java.util.Scanner;

// 백만 장자 프로젝트, D2, 20분
public class SEA_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) arr[i] = sc.nextInt();
			
			int max = arr[N-1];
			long res = 0;
			for(int i=N-2; i>=0; i--) {
				if(max > arr[i]) res += max - arr[i];
				else max = arr[i];
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}
