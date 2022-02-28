package defa;

import java.util.Scanner;

// 컵홀더, 브론즈 1, 5분
public class BOJ_2810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		char[] map = s.toCharArray();
		
		int res = 1; // 첫 번째 칸에는 무조건 컵홀더가 있다
		
		for(int i=0; i<N; i++) {
			if(map[i]=='S') { // 내 오른쪽 컵홀더 세기
				res++;
			}
			else if(map[i]=='L') { // 내 오른쪽 컵홀더 세기. 단, 한 자리 건너뛰기
				i++;
				res++;
			}
		}
		// 3 SSS 가 입력으로 들어오는 경우 4가 되는데, 이경우엔 그냥 사람 수 출력
		if(res>N) System.out.println(N);
		else System.out.println(res);
	}

}
