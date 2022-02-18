import java.util.Scanner;

public class Main {
	static int r, c, cnt = 0; // 메소드에서 값을 비교하기 위한 정적할당
	static int[] dx = {0,0,1,1};  // 행 이동
	static int[] dy = {0,1,0,1}; // 열 이동
	
	static void dfs(int row, int col, int N) {
		if(N==2) { //크기가 2일 때  검사 진행

			for(int i=0; i<4; i++) {
				if(row+dx[i]==r && col+dy[i]==c) { //만약 있다면 현재까지의 카운트 출력
					System.out.println(cnt);
					break;
				}
				cnt++;
			}
			return;
		}
		if(r<row || r>=row+N || c<col || c>col+N) { //사각형 내부에 r, c가 없다면 탐색 스킵
			cnt += N*N;
			return;
		}
		dfs(row,col,N/2); // 1 사분면
		dfs(row,col+N/2,N/2); // 2 사분면
		dfs(row+N/2,col,N/2); // 3 사분면
		dfs(row+N/2,col+N/2,N/2); // 4 사분면
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int length = (int)Math.pow(2, N); // 사각형의 한 변은 2의 N승
		
		dfs(0,0,length); // 행, 열, 크기
}
}