import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		int [][] map =new int[100][100]; //100x100배열생성
		int[][] arr =new int [N][2];
		int res=0;
		for(int i=0;i<N;i++) {
			arr[i][1] = sc.nextInt(); //x저장
			arr[i][0] = sc.nextInt(); //y저장
		}
		for(int i=0;i<N;i++) {
			for(int j=arr[i][0];j<arr[i][0]+10;j++) { //저장된 점 기준 세로 10번
				for(int k=arr[i][1];k<arr[i][1]+10;k++) { //가로 10번 반복
					map[j][k] =1; //해당 위치 1로 변경
				}
			}
		}
		
		//색종이 붙은영역은 1, 아닌영역은 0
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				res+=map[i][j]; //다 더하면 넓이 구할수 있음
			}
		}
		System.out.println(res);
	}
}
