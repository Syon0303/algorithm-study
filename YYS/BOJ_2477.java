import java.util.*;

public class Main {
	public static void main(String[] args){
		//반시계 방향 회전: 4 2 3 1 = 북서남동
		Scanner sc = new Scanner(System.in);
		int[] cycle = {4,2,3,1};
		int K = sc.nextInt();
		int[][] length = new int[6][2];
		for(int i=0; i<6; i++) {
			length[i][0] = sc.nextInt();
			length[i][1] = sc.nextInt();
		}
		int now = 0;
		for(int i=0; i<4; i++) {
			if(cycle[i]==length[0][0]) {
				now = i;
			}
		}
		int inner1=0,inner2=0,outer1=0,outer2=0;
		for(int i=1;i<7; i++) {
			now = (now+1)%4;
			i = i%6;
			if(length[i][0]!=cycle[now]) {
				//예측했던 회전방향과 달라지는 경우
				inner1=length[i][1];
				inner2=length[(i+5)%6][1];
				outer1=length[(i+2)%6][1];
				outer2=length[(i+3)%6][1];
				i=6;
			}
		}
		System.out.println((outer1*outer2-inner1*inner2)*K);
	}
}