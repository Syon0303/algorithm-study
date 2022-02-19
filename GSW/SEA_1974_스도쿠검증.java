import java.util.Scanner;
import java.io.FileInputStream;

class Solution2
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[][] arr = new int [9][9];
		
		int [][]start = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}}; // 3x3시작점 9개
		outer: for(int test_case =1; test_case<=tc;test_case++) {
			
			for(int i=0;i<9;i++) { //입력받기
				for(int j=0;j<9;j++)
				arr[i][j] = sc.nextInt();
			} 
			//3x3검증
			for(int i=0;i<9;i++) {
				int[] check = new int [10];
				for(int j=start[i][1];j<start[i][1]+3;j++) { //3x3크기 순회
					for(int k=start[i][0];k<start[i][0]+3;k++) {
						check[arr[j][k]]++; //3x3에 입력된 값을 인덱스로 사용후 +1
					}
				} 
				for(int k=1;k<10;k++) {
					if(check[k]==0) { //1~9중 값이 0인게 있으면 규칙에 맞지 않음
						System.out.println("#"+test_case+" 0"); //결과 출력
						continue outer; //반복문 바로탈출
					}
				}
				
			}
			//각각의 행, 열 검증
			for(int j=0;j<9;j++) {
				int[] check2 = new int [10];
				int[] check3 = new int [10];
				for(int k=0;k<9;k++) {
					check2[arr[j][k]]++;
					check3[arr[k][j]]++;
				}
				for(int k=1;k<10;k++) {
					if(check2[k]==0||check3[k]==0) {
						System.out.println("#"+test_case+" 0");
						continue outer;
					}
				}
			}
			
			System.out.println("#"+test_case+" 1");
			
			
		}
	}
}