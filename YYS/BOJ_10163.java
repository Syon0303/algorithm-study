import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[1001][1001]; //평면 배열 생성
		int[] counting = new int[N+1]; //개수를 세어줄 카운팅 배열
		
		// 입력: 행 열 너비 높이
		for(int c=1; c<=N; c++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			for(int i=col; i<col+height; i++) {
				for(int j=row; j<row+width; j++) {
					 arr[i][j]=c; // 현재 적는 색종이로 덮어씌우기
				}
			}
		}
		for(int i=0; i<1001; i++) { // 한바퀴돌면서 적혀진 숫자를 카운팅배열에 추가
			for(int j=0; j<1001; j++) {
				 counting[arr[i][j]]++;
			}
		}
		
		for(int i=1; i<=N; i++) { // 카운팅배열의 숫자를 출력
			System.out.println(counting[i]);
		}
}
}