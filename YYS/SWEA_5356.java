import java.util.*;
public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			String[] s= new String[5];
			int max = 0;
			for(int i=0; i<5; i++) {
				s[i] = sc.next();
				max = Math.max(max, s[i].length());
			}
			for(int i=0; i<max; i++) {
				for(int j=0; j<5; j++) {
					if(i<s[j].length()) {
						sb.append(s[j].charAt(i));
					}
				}
			}
			System.out.println("#"+t+" "+sb.toString());
			sb.setLength(0);
		}
	}
}