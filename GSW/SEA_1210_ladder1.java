import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
public class Solution {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		String [][] map;
		Scanner sc = new Scanner(System.in);
		//int testCase = sc.nextInt();
		for(int t=1;t<=10;t++) {
			////////////////////////////
			sc.nextLine();
			int[] xy = new int[2]; //xy[0] -> y축, xy[1] ->x축 
			
			map = new String[100][100];
			for(int i=0;i<100;i++) {
				map[i] = sc.nextLine().split(" ");
			} //사다리 읽기
			
			for(int i=0;i<100;i++) { //도착지점 찾기
				if(map[99][i].equals("2")) {
					xy[0] = 99;
					xy[1] = i;
				}
			}
			while(xy[0]!=0) {//맨위 도착할때까지
				//오른쪽이동
				if(xy[1]<99&&map[xy[0]][xy[1]+1].equals("1")) {
					while(true) {
						if(xy[1]==99||map[xy[0]][xy[1]+1].equals("0")) break;
						xy[1]++;
					}
					xy[0]--;
					
					
				}
				//왼쪽이동
				else if(xy[1]>0&&map[xy[0]][xy[1]-1].equals("1")) {
					while(true) {
						if(xy[1]==0||map[xy[0]][xy[1]-1].equals("0")) break;
						xy[1]--;
					}
					xy[0]--;
				}
				else {
					xy[0]--;
				}
			}
			System.out.printf("#%d %d\n",t,xy[1]);
			////////////////////////
		}
	}
}
