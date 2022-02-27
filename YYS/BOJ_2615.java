import java.util.*;
public class Main {
	public static void main(String[] args){
		int[][] arr = new int[19][19];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int WIN = 0; // 승리자 저장 배열
		int[] start = new int[2];
		boolean find = false; //승리 판단
		// 가로 검사
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				
				int num = arr[i][j]; //현재 검사하는 곳 숫자
				if(num==0) continue; //0이라면 가지치기
				if(j-1>=0 && arr[i][j-1]==num) { // 왼쪽이 현재 숫자와 같으면 검사했다는 뜻
					continue;
				}
				int count = 1;
				while(true) {
					if(j+count>=19 || arr[i][j+count]!=num) {
						break;
					}
					count++;
				}
				
				if(count==5) {
					find = true;
					WIN = num;
					start[0] = i+1;
					start[1] = j+1;
					i = 19;
					j= 19;
					continue;
				}
				j += count-1;
			}
		}
		//승리가 결정되지 않았다면 세로 검사
		if(!find) {
			for(int j=0; j<19; j++) {
				for(int i=0; i<19; i++) {
					int num = arr[i][j]; //현재 검사하는 곳 숫자
					if(num==0) continue; //0이라면 가지치기
					if(i-1>=0 && arr[i-1][j]==num) { 
						continue;
					}
					int count = 1;
					while(true) {
						if(i+count>=19 || arr[i+count][j]!=num) {
							break;
						}
						count++;
					}
					
					if(count==5) {
						find = true;
						WIN = num;
						start[0] = i+1;
						start[1] = j+1;
						i = 19;
						j= 19;
						continue;
					}
					i += count-1;
			}
		}
		}
			//오른쪽 아래 대각선 :14 15 16 17 18 ( 15부터는 시작할 수 없다)
		if(!find) {
			for(int i=0; i<15; i++) {
				for(int j=0; j<15; j++) {
					//탐색 위치마다 초기화
					int num = arr[i][j]; //현재 검사하는 곳의 숫자
					if(num==0) continue; //0이라면 가지치기
					if(i-1>=0 && j-1>=0 && arr[i-1][j-1]==num) { // 왼쪽 대각선 위에가 0이 아니라면 이미 검사했다는 뜻
						continue;
					}
					
					int count = 1;

					while(true) {
						if(i+count>=19 || j+count>=19 || arr[i+count][j+count]!=num) {
							break;
						}
						count++;
					}
					if(count==5) {
						find = true;
						WIN = num;
						start[0] = i+1;
						start[1] = j+1;
						i = 19;
						j= 19;
						continue;
					}
				}
			}
		}
				//왼쪽 아래 대각
		if(!find) {
			for(int i=0; i<19; i++) {
				for(int j=0; j<19; j++) {
					//탐색 위치마다 초기화
					int num = arr[i][j]; //현재 검사하는 곳의 숫자
					if(num==0) continue; //0이라면 가지치기
					if(i-1>=0 && j+1<19 && arr[i-1][j+1]==num) { // 오른쪽 대각선 위에가 0이 아니라면 이미 검사했다는 뜻
						continue;
					}
					
					int count = 1;

					while(true) {
						if(i+count>=19 || j-count<0 || arr[i+count][j-count]!=num) {
							break;
						}
						count++;
					}
					if(count==5) {
						find = true;
						WIN = num;
						start[0] = i+5;
						start[1] = j-3;
						i = 19;
						j= 19;
						continue;
					}
				}
			}
	
	
		}
		if(find) {
			System.out.printf("%d%n%d %d",WIN,start[0],start[1]);
		}else {
			System.out.print(0);
		}
	}
}