import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int N = Integer.parseInt(st.nextToken());
		 int M = Integer.parseInt(st.nextToken());
		 int R = Integer.parseInt(st.nextToken());
		 int[][] matrix = new int[N][M];
		 int[][] direction = new int[N][M];
		 int[][] count = new int[N][M];
		 int[][] answer = new int[N][M];
		 int shell = Math.min(N, M)/2;
		 int element = 2*(M+N)-4; //원소 개수
		 
		 for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<M; j++) {
				 matrix[i][j] = Integer.parseInt(st.nextToken());
				 
			 }
		 }

		 
		 for(int s=0; s<shell; s++) {
			 int start = s;
			 int row_last = N-1-s;
			 int col_last = M-1-s;
			 int net_R = R%element;
			 for(int i=start; i<=col_last; i++) {
				 direction[start][i] = 3; // 첫째줄
				 direction[row_last][i] = 4; //마지막 줄
				 count[start][i] = net_R;
				 count[row_last][i] = net_R;
			 }
			 for(int j=start; j<=row_last; j++) {
				 direction[j][start] = 2; //첫째열
				 direction[j][col_last] = 1; //마지막 열
				 count[j][start] = net_R;
				 count[j][col_last] = net_R;
			 }
			 direction[start][start] = 2; //왼쪽 위 모서리
			 direction[row_last][start] = 4; //왼쪽 아래 모서리
			 direction[row_last][col_last] = 1; //오른쪽 아래 모서리
			 direction[start][col_last] = 3; //오른쪽 위 모서리
			 
			 element -= 8;
		 }
		 for(int i=0; i<N;i++) {
			 for(int j=0; j<M;j++) {
				int row=i;
				int col=j;
				while(count[i][j]-->0) {
					
					switch(direction[row][col]) {
						case 1: row--; break;
						case 2: row++; break;
						case 3: col--; break;
						case 4: col++; break;
					}
				}
				answer[row][col] = matrix[i][j];
			 }
		 }
		 
		 for(int i=0; i<N;i++) {
			 for(int j=0; j<M;j++) {
				System.out.print(answer[i][j]+" ");
			 }
			 System.out.println();
		 }
		
}
}