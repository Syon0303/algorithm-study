import java.util.*;

public class Solution { //어제 보충 시간에 풀었습니다
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int arr[][];		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			arr = new int [9][9];
			boolean judge = true;
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int sum1,sum2,sum3;
			
			for(int i=0; i<9; i++) {  //행렬 각각의 합이 45인지 체크
				sum1 = 0;
				sum2 = 0;
				for(int j=0; j<9; j++) {
					sum1 += arr[i][j];
					sum2 += arr[j][i];
				}
				if(sum1!=45 || sum2!=45) {
					judge = false;
					i=10;
				}
			}
			
			for(int i=0; i<3; i++) { //3x3 사각형들이 모두 합이 45인지 체크
				for(int j=0; j<3; j++) {
					sum3 = 0;
					for(int k=i*3; k<i*3+3; k++) {
						for(int l=j*3; l<j*3+3; l++) {
							sum3 += arr[k][l];
						}
					}
					if(sum3!=45) {
						judge = false;
						j=10;
						i=10;
					}
				}
			}
			//위 하나라도 만족하지 않으면 틀림: 반례 = 모든 숫자가 5인 경우
			System.out.println("#"+t+" "+(judge?1:0));
		}
	}
}