package day15;

import java.util.Scanner;

// 영준이의 카드 카운팅, D3, 20분
public class SEA_4047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			String s = sc.next();
			
			boolean[][] v = new boolean[4][13];
			boolean flag = true;
			
			for(int i=0; i<s.length(); i+=3) {
				String myStr = s.substring(i, i+3);
				char pattern = myStr.charAt(0);
				int myNum = Integer.parseInt(myStr.substring(1, 3))-1;
				
				if(pattern == 'S') {
					if(v[0][myNum] != true) {
						v[0][myNum] = true;
					}
					else {
						flag = false;
						break;
					}
				}
				
				else if(pattern == 'D') {
					if(v[1][myNum] != true) {
						v[1][myNum] = true;
					}
					else {
						flag = false;
						break;
					}
				}
				
				else if(pattern == 'H') {
					if(v[2][myNum] != true) {
						v[2][myNum] = true;
					}
					else {
						flag = false;
						break;
					}
				}
				
				if(pattern == 'C') {
					if(v[3][myNum] != true) {
						v[3][myNum] = true;
					}
					else {
						flag = false;
						break;
					}
				}
				
			}
			if(!flag) sb.append("ERROR");

			else {
				for(int i=0; i<4; i++) {
					int cnt = 0;
					for(int j=0; j<13; j++) {
						if(v[i][j]) cnt++;
					}
					sb.append(13-cnt).append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}
