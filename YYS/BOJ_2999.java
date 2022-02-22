import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int N = s.length();
		int R = N/2; // N을 반으로 쪼개서 R을 주기
		int C=0;
		
		while(true) { //N을 R로 나눈 나머지가 0일 때 R<=C 를 만족하면 break;
			if(N%R==0 && R<=N/R) {
				C=N/R;
				break;
			}
			R--;
		}
		
		int idx=0;
		// 위에서 아래 -> 왼쪽 오른쪽으로 채워주기
		char[][] arr = new char[R][C];
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				arr[j][i]=s.charAt(idx);
				idx++;
			}
		}
		// 왼쪽 -> 오른쪽, 위 -> 아래로 읽어주기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(arr[i][j]);
			}
		}
}
}