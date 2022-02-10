package workplace;
import java.util.*;
import java.io.*;
 
public class Solution {
	static int[][] arr = new int[100][100];
	static int answer,row,col;
	
	// dfs 분기로 풀이했습니다.
	static void dfs(char direction) {
		// 탐색 방향은 위(u), 좌(l), 우(r)
		switch(direction) {
		
		case 'u': // 이전에 위로 움직였을 때 : 좌우 살피기
			row --;
			if(row==0) { // 맨 위에 도달하면 dfs 끝
				return;
			}else if(col+1<100 && arr[row][col+1]==1) { //오른쪽에 1이 있으면 이동
				dfs('r');
			}else if(col-1>=0 && arr[row][col-1]==1) { //왼쪽에 1이 있으면 이동
				dfs('l');
			}else {
				dfs('u'); //없으면 위로 이동
			}
			
			break;
			
		case 'l': // 이전 움직임이 왼쪽이었을 때
			col --;
			if(arr[row-1][col]==1) {
				dfs('u'); // 위가 1이면 이동
			}else {
				dfs('l'); // 없으면 계속 왼쪽 이동
			}
			break;
			
		case 'r':
			col += 1;
			if(arr[row-1][col]==1) {
				dfs('u');
			}else {
				dfs('r');
			}
			break;
		}
	}
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    for(int t = 1; t<=10; t++) {
    	br.readLine();
    	for(int i=0; i<100; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<100; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	//2 찾기
    	row = 99;
    	col = 0;
    	for(int i = 0; i<100; i++) {
    		if(arr[99][i] == 2) {
    			col = i;
    			i = 100; //종료
    		}
    	}
    	
    	dfs('u');
    	
    	System.out.println("#"+t+" "+col);
    }
}
}