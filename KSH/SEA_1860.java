package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 진기의 최고급 붕어빵, D3
public class SEA_1860 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			// 손님 도착 시간에 맞는 arr 생성
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=0; i<N; i++) {
				int temp = sc.nextInt();
				arr.add(temp);
			}
			// 이정도는 오름차순으로 그냥 오게 해줘도 되는거 아닐까..
			// 만약 1초에 한 명 2초에 한 명 온 경우 arr = {1, 2}
			Collections.sort(arr);
			
			boolean flag = true;
			
			for(int i=0; i<N; i++) {
				// arr에 1과 2가 들어와있음
				int temp = arr.get(i);
				// temp = 1초에 만든 붕어빵의 수
				// M초에 K개씩 만들 수 있다.
				// 2초에 2개씩 만들 수 있다.
				// 2초 * (1 / 2개) = 1개
				// 괄호 주의해야한다. 만약 괄호가 없다면 2*2/2 = 1이 되지만 2*(1/2)하면 0이됨
				int sum = K * (temp / M);
				// a[i]초에 만든 붕어빵 수가 이때까지 도착한 손님 수보다 작다면
				if(sum < (i+1)) flag = false;
			}
			if(flag) System.out.println("#" + test_case + " " + "Possible");
			else System.out.println("#" + test_case + " " + "Impossible");	
		}
	}
}
