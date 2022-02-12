import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int row, col, R, arr[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		row = Integer.parseInt(stn.nextToken()); // 배열 행
		col = Integer.parseInt(stn.nextToken()); // 배열 열
		R = Integer.parseInt(stn.nextToken()); // 회전 횟수
		arr = new int[row][col];		
		// 배열 입력 받기
		for (int i = 0; i < row; i++) {
			stn = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(stn.nextToken());
			}
		}
		// 배열 회전
		for (int i = 0; i < R; i++) {
			rotate();
		}
		// 배열 출력
		for (int j = 0; j < row; j++) {
			for (int j2 = 0; j2 < col; j2++) {
				System.out.print(arr[j][j2]+" ");
			}
			System.out.println();
		}
	}
	
	public static void rotate() {
		// min(N,M) mod 2 = 0 => 작은 게 짝수
		int level = Math.min(row, col) / 2;
		
		for (int cnt = 0; cnt < level; cnt++) {
			int r_max = row - cnt - 1; // 각 사각형의 세로 최대 길이
			int c_max = col - cnt - 1; // 각 사각형의 가로 최대 길이
			
			int temp = arr[cnt][cnt]; // 사각형의 첫 원소 저장해두기
			
			// 왼쪽으로 이동
			for(int i = cnt; i < c_max; i++) {
				arr[cnt][i] = arr[cnt][i+1];
			}
			// 위쪽으로 이동
			for(int i = cnt; i < r_max; i++) {
				arr[i][c_max] = arr[i+1][c_max];
			}
			// 오른쪽으로 이동
			for(int i = c_max; i > cnt; i--) {
				arr[r_max][i] = arr[r_max][i-1];
			}
			// 아래쪽으로 이동
			for(int i = r_max; i > cnt; i--) {
				arr[i][cnt] = arr[i-1][cnt];
			}
			// 첫 원소 붙이기
			arr[cnt+1][cnt] = temp;
		}
	}
}