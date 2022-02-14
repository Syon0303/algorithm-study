import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_돌리기1 {

	public static void main(String[] args) throws IOException {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = sc.nextInt();
		int [][] map =new int[N][M]; //100x100배열생성
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int num = Math.min(N, M)/2;
		int temp;
		for(int i=0;i<cnt;i++) {
			for(int j=0;j<num;j++) {
				temp = map[j][j];
				for(int k=j+1; k<M-j; k++)
					map[j][k-1] = map[j][k];
				
				for(int k=j+1; k<N-j; k++)
					map[k-1][M-1-j] = map[k][M-1-j];
				
				for(int k=M-2-j; k>=j; k--)
					map[N-1-j][k+1] = map[N-1-j][k];
				
				for(int k=N-2-j; k>=j; k--)
					map[k+1][j] = map[k][j];
				
				map[j+1][j] = temp;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0; j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
