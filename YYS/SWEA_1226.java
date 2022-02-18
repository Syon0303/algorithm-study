import java.util.*;

public class Solution {
	static boolean judge; //닿을 수 있는가 판단하는 변수
	static int arrive[],arr[][];
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static void dfs(int row, int col) {
		
		if(arr[row][col]==1 || judge || row<0 || col <0 || row==16 || col==16) {
			return;
		}
		
		if(arr[row][col]==3) {
			judge = true;
			return;
		}
		
		arr[row][col] = 1; //한 번 지나온 구역 표시
		
		for(int i=0; i<4; i++) {
			dfs(row+dx[i],col+dy[i]);
		}
	}
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        for(int t = 1; t<=10; t++) {
        	int N = sc.nextInt();
        	arr = new int[100][100];
        	int[] start = new int[2];
        	
        	judge = false;
        	for(int i=0; i<16; i++) {
        		String s = sc.next();
        		for(int j=0; j<16; j++) {
            		arr[i][j] = Character.getNumericValue(s.charAt(j));
            		if(arr[i][j]==2) {
            			start[0] = i;
            			start[1] =j;
            		}
            	}
        	}
        	
        	dfs(start[0],start[1]);
        	System.out.println("#"+t+" "+(judge?1:0));
        }
	}
}