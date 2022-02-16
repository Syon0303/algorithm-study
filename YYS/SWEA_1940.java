import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int S = 0;
			int	V = 0;
			while(N-->0) {

				int input = sc.nextInt();
				int amount = 0; //0은 입력값을 하나만 받습니다.
				
                switch(input) {
					case 0: break;
					case 1: amount = sc.nextInt(); break; //계산 유형이 1이나 2일 때 새로 입력값을 받습니다
					case 2: amount = sc.nextInt()*(-1); break;
				}
				V += amount;

                if(V<0) V=0; //V가 0보다 작아지면 0으로 고정합니다.
				
                S += V;
			}
			System.out.println("#"+t+" "+Math.abs(S));
		}
		
}
}