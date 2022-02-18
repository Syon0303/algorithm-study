package day8;
import java.util.Scanner;

public class SEA_6808 {

	static int[] myArr;
	static int winCnt;
	static int[] res;
	static boolean[] v;
	
	static int SIZE = 362880;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			// 전체 카드 입력
			v = new boolean[19];
			myArr = new int[10];
			for(int i=1; i<=9; i++) {
				int temp = sc.nextInt();
				v[temp] = true;
				myArr[i] = temp;
			}

			winCnt = 0; // 규영이가 이긴 횟수
			
			func(0, 0, 0);
			System.out.println("#" + test_case + " " + winCnt + " " + Integer.toString(SIZE-winCnt));
		}
	}
	
	// win : 규영이 점수, lose : 인영이 점수
	static void func(int cnt, int win, int lose) {
		if(cnt == 9 && win>lose) {
			winCnt++;
		}
		for(int i=1; i<=18; i++) {
			if(v[i]) continue;
			v[i] = true;
			int score = myArr[cnt + 1] + i;
			
			if(myArr[cnt+1] > i) { // 규영이가 이긴다면
				func(cnt+1, win+score, lose);
			} else {
				func(cnt+1, win, lose+score);
			}
			v[i] = false;
		}
	}

}
