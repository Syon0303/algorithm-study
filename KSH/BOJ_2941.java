package day13;

import java.util.Scanner;
// 크로아티아 알파벳, 실버 5, 10분
public class BOJ_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int res = 0;
		String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<alpha.length; j++) {
				if(s.substring(i).startsWith(alpha[j])) {
					i = i + alpha[j].length()-1;
					break;
				}
			}
			res++;
		}
		System.out.println(res);
	}
}
