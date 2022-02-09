package workplace;
import java.util.*;
import java.io.*;
 
public class Solution {
	static int[][] arr = new int[100][100];
	static int answer,row,col;
	
	// dfs �б�� Ǯ���߽��ϴ�.
	static void dfs(char direction) {
		// Ž�� ������ ��(u), ��(l), ��(r)
		switch(direction) {
		
		case 'u': // ������ ���� �������� �� : �¿� ���Ǳ�
			row --;
			if(row==0) { // �� ���� �����ϸ� dfs ��
				return;
			}else if(col+1<100 && arr[row][col+1]==1) { //�����ʿ� 1�� ������ �̵�
				dfs('r');
			}else if(col-1>=0 && arr[row][col-1]==1) { //���ʿ� 1�� ������ �̵�
				dfs('l');
			}else {
				dfs('u'); //������ ���� �̵�
			}
			
			break;
			
		case 'l': // ���� �������� �����̾��� ��
			col --;
			if(arr[row-1][col]==1) {
				dfs('u'); // ���� 1�̸� �̵�
			}else {
				dfs('l'); // ������ ��� ���� �̵�
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
    	
    	//2 ã��
    	row = 99;
    	col = 0;
    	for(int i = 0; i<100; i++) {
    		if(arr[99][i] == 2) {
    			col = i;
    			i = 100; //����
    		}
    	}
    	
    	dfs('u');
    	
    	System.out.println("#"+t+" "+col);
    }
}
}