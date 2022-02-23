import java.io.*;
import java.util.*;
public class Solution {
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=1; t<=T; t++) {
		String s = sc.next();
		boolean[][] ALL = new boolean[4][14]; // 0 = S / 1 = D / 2 = H / 3 = C 
		int[] answer = {13,13,13,13};
		boolean judge = true;
		for(int i=0; i<s.length(); i+=3) {
			int shape = -1; // 카드모양
			switch(s.charAt(i)) {
			case 'S': shape = 0; break;
			case 'D': shape = 1; break;
			case 'H': shape = 2; break;
			case 'C': shape = 3; break;
			}
			
			int number = Integer.parseInt(s.substring(i+1,i+3));
			if(ALL[shape][number]) {
				judge = false;
				i = s.length();
				continue;
			}else {
				ALL[shape][number] = true;
				answer[shape] --;
			}
		}
		System.out.print("#"+t);
		if(judge) {
			System.out.println(" "+answer[0]+" "+answer[1]+" "+answer[2]+" "+answer[3]);
		}else {
			System.out.println(" ERROR");
		}
	}
	 
}
}