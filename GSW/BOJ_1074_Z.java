import java.io.IOException;
import java.util.Scanner;

public class MainZ {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int line = (int)Math.pow(2,N);
		int res=0;
		int sector = 0;
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		//  nxn크기의 배열을 4등분
		//  0  1
		//  2  3  구역으로 나눔
		//  현재 행,열에 맞춰서 구역 할당 
		
		while(true) {
			
			if(line==2) { //만약 2x2배열이 되면 0행0열 , 0행1열, 1행0열, 1행1열 순으로 탐색함 -> 00 01 10 11 이진수랑 똑같음 
				res+=r*2+c*1; 
				break;
			}
			
			//현재 행열이 위치한 구역 찾기
			if(r<line/2&&c<line/2) {  
				sector =0;
			}
			else if(r<line/2&&c>=line/2) {
				sector = 1;
			}
			else if(r>=line/2&&c<line/2) {
				sector = 2;
			}
			else if(r>=line/2&&c>=line/2) {
				sector = 3;
			}
			
			//현재 구역 앞에 위치한 구역의 원소는 모두 탐색한 상황임  2번구역은 0,1구역을 모두 지나치고 온것, 
			res += sector*(line*line/4); //한 구역의 원소수 * 구역 번호 -> 앞서 지나온 구역에 있는 원소수
			
			//다음 반복때 현재구역을 전체로 생각하고 진행 하기 때문에 line, 행, 열 조정
			line = line/2; 
			r=r%line;  
			c=c%line;
		}
		System.out.println(res);
	}


}