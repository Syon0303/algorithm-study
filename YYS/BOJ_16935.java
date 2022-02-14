import java.io.*;
import java.util.*;

public class Main {
	static int[][] matrix,ans;
	static int reverse = 1; //NxM 상태
	static int N,M;
	
	static void swap() {
		int tmp = N;
		N = M;
		M = tmp;
	}
	
	static int[][] cal1(int[][] m) { //상하
		int[][] ans = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				ans[N-i-1][j] = m[i][j];
			}
		}
		return ans;
	}
	
	static int[][] cal2(int[][] m) { //좌우
		int[][] ans = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ans[i][M-1-j] = m[i][j];
			}
		}
		return ans;
	}
	
	static int[][] cal3(int[][] m) { //오른회전
		int[][] ans = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ans[j][N-1-i] = m[i][j];
			}
		}
		swap();
		return ans;
	}
	
	static int[][] cal4(int[][] m) { //왼회전
		int[][] ans = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ans[M-1-j][i] = m[i][j];
			}
		}
		swap();
		return ans;
	}
	
	static int[][] cal5(int[][] m) { //부분  1-2-3-4 회전
		int[][] ans = new int[N][M];
		int row_length = N/2;
		int col_length = M/2;
		for(int i=0; i<row_length; i++) { // 1 에서 2 이동
			for(int j=0; j<col_length; j++) {
				ans[i][col_length+j] = m[i][j];
			}
		}
		for(int i=0; i<row_length; i++) {  // 2에서 4 이동
			for(int j=col_length; j<2*col_length; j++) {
				ans[i+row_length][j] = m[i][j];
			}
		}
		for(int i=row_length; i<2*row_length; i++) {  // 3에서 1 이동
			for(int j=0; j<col_length; j++) {
				ans[i-row_length][j] = m[i][j];
			}
		}
		for(int i=row_length; i<2*row_length; i++) {  // 4에서 3 이동
			for(int j=col_length; j<2*col_length; j++) {
				ans[i][j-col_length] = m[i][j];
			}
		}
		return ans;
	}
	
	static int[][] cal6(int[][] m) { //부분  4-1-2-3 회전
		int[][] ans = new int[N][M];
		int row_length = N/2;
		int col_length = M/2;
		for(int i=0; i<row_length; i++) { // 1 에서 3 이동
			for(int j=0; j<col_length; j++) {
				ans[i+row_length][j] = m[i][j];
			}
		}
		for(int i=0; i<row_length; i++) {  // 2에서 1 이동
			for(int j=col_length; j<2*col_length; j++) {
				ans[i][j-col_length] = m[i][j];
			}
		}
		for(int i=row_length; i<2*row_length; i++) {  // 3에서 4 이동
			for(int j=0; j<col_length; j++) {
				ans[i][j+col_length] = m[i][j];
			}
		}
		for(int i=row_length; i<2*row_length; i++) {  // 4에서 2 이동
			for(int j=col_length; j<2*col_length; j++) {
				ans[i-row_length][j] = m[i][j];
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 int R = Integer.parseInt(st.nextToken());
		 matrix = new int[N][M];

		 for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<M; j++) {
				 matrix[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 st = new StringTokenizer(br.readLine());
		 for(int i=0; i<R; i++) {
			 switch(Integer.parseInt(st.nextToken())) {
			 case 1: matrix = cal1(matrix); break;
			 case 2: matrix = cal2(matrix); break;
			 case 3: matrix = cal3(matrix); reverse*=-1; break;
			 case 4: matrix = cal4(matrix); reverse*=-1; break;
			 case 5: matrix = cal5(matrix); break;
			 case 6: matrix = cal6(matrix); break;
			 }
		 }
		 for(int i=0; i<N; i++) {
			 for(int j=0; j<M; j++) {
				 System.out.print(matrix[i][j]+" ");
			 }
			 System.out.println();
		 }

}
}