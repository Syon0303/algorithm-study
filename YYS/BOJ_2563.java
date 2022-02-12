import java.util.Scanner;

public class Main {
	static int L = 10; // 색종이 길이
	static boolean[][] area = new boolean[101][101];
	
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cnt = 0;
    for(int i=sc.nextInt(); i>0; i--) {
    	int x = sc.nextInt();
    	int y = sc.nextInt();
    	for(int row=x; row<x+L; row++) { // 행
    		
    		if(row>=100) {
    			row=x+L; continue; // 범위를 벗어나면 반복문을 나옵니다
    		}else {
    			for(int col=y; col<y+L; col++) { //열
    				
    				if(col>=100) {
    	    			col=y+L; continue; //범위를 벗어나면 반복문을 나옵니다
    	    		}else {
    	    			if(!area[row][col]) { //체크안되어있다면
    	    				cnt++; //카운트 후
    	    				area[row][col] = true; //체크
    	    			}
    	    		}
    			}
    		}
    	}
    }
    System.out.println(cnt);
}
}