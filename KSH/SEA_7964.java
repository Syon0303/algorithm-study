package day15;

import java.util.Scanner;

// 부먹왕국의 차원 관문, D3, 20분
public class SEA_7964 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] map = new int[N];
			for(int i=0; i<N; i++) map[i] = sc.nextInt();
			
			
			int cnt = 0; // 한 칸 씩 움직일 때마다 cnt++ (이동거리 제약) 
			int res = 0; // 설치해야 하는 차원 관문의 수
			
			if(map[0] == 0) { // 0번째는 무조건 차원 관문이 필요
				res++;
				map[0] = 1;
			}
			
			if(map[N-1] == 0) { // N-1 번째는 무조건 차원 관문이 필요
				res++;
				map[N-1] = 1;
			}
			
			for(int i=0; i<N; i++) {
				if(map[i] == 1) cnt = 0; // 만약 차원 관문이 설치되어 있다면
				else {
					cnt++; // 일단 한 칸 더 움직여라
					
					if(cnt >= D) { // 한 칸 더 움직인 내 움직임이 이동 제한 거리보다 크다면
						res++; // 여기에 차원 관문을 설치한다
						cnt = 0; // 카운트를 초기화 
					}
				}
			}
			
			System.out.println("#" + test_case + " " + res);
			
		}
	}
}
