import java.util.Scanner;

// Ladder1
public class SEA_1210 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = 100;
			int map[][] = new int[N][N];
			// 맨 처음 tc (사용하지 않음)
			int tc = sc.nextInt();
			
			// 내 현재 위치
			int x = N-1;
			int y = 0;
			
			// 맵 입력 도중에 만약 2가 나오면, 해당 열 번호를 y에 넣어라 ((99, y)부터 시작)
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) y = j;
				}
			}
			
			// 올라간다. (while 검사하면서 1 줄이기, x가 0이면 종료)
			while(x != 0) {
				
				// 오른쪽 검사
				// 만약 오른쪽으로 가는데 오른쪽이 벽이 아니고 오른쪽이 1이라면
				if(y+1<N && map[x][y+1]==1) {
					// 오른쪽이 벽이 아니고 오른쪽이 1이라면 오른쪽으로 이동
					while(y+1<N && map[x][y+1]==1) y++;
				}
				
				// 왼쪽 검사
				// 만약 오른쪽에 1이 없다면
				else {
					// 왼쪽이 벽이 아니고 왼쪽이 1이라면 왼쪽으로 이동
					while(y-1>=0 && map[x][y-1]==1) y--;
				}
				
				x--;
			}
			
			System.out.println("#" + test_case + " " + y);
		}
		
	}

}
