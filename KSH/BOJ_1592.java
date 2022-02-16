package day10;

import java.util.Scanner;

/*
 * 영식이와 친구들
 * 브론즈 2, 10분
 */
public class BOJ_1592 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 수
		int M = sc.nextInt(); // 한 사람이 공을 이만큼 받으면 게임 끝
		int L = sc.nextInt(); // 공 받은 횟수가 홀수면, 시계로 L번째 있는 사람에게, 짝수면 반시계 방향으로 L번째 있는 사람에게 공을 준다.
		
		int[] map = new int[N]; // 공을 받은 횟수 카운트
		map[0] = 1; // 처음엔 무조건 1번이 공을 잡는다.
		int idx = 0; // 현재 공의 위치
		
		while(true) {
			if(M==1) break;
			
			if(map[idx]%2 == 1) { // 홀수인 경우
				idx+=L;
				if(idx>=N) idx=idx-N;
				map[idx]++;

			}
			else { // 짝수인 경우
				idx-=L;
				if(idx<0) idx=idx+N;
				map[idx]++;
			}
			
			if(map[idx]==M) break;
		}
		
		int res = 0;
		for(int i:map) res+=i;
		System.out.println(res-1);
	}

}
