package day13;

import java.util.Scanner;
// 비밀 이메일, 브론즈 1, 20분
public class BOJ_2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] myChar = sc.nextLine().toCharArray();
		int len = myChar.length;
		
		int R = 0;
		int C = 0;
		
		// 문자열의 길이가 나누어 떨어지는 수이면서
		// R <= C를 만족하는 경우
		for(int i=1; i<len; i++) {
			if(len%i==0 && i<=len/i) {
				R = i;
				C = len / i;
			}
		}
		int myidx = 0;
		char[][] map = new char[C][R];
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				map[i][j] = myChar[myidx];
				myidx++;
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[j][i]);
			}
		}
	}

}
