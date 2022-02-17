package day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 집합
 * 실버 5
 */
public class BOJ_11723 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int myBit = 0;

		for(int t=0; t<T; t++) {
			String tempStr = br.readLine();
			String[] s = tempStr.split(" ");
			int temp = 0;
			if(!(s[0].equals("all") || s[0].equals("empty"))) {
				temp = Integer.parseInt(s[1]);
			}
			
			if(s[0].equals("add")) {
				myBit = myBit | 1<<(temp-1);
			}
			else if(s[0].equals("remove")) {
				myBit = myBit & ~(1<<(temp-1));
			}
			else if(s[0].equals("check")) {
				if((myBit & 1<<(temp-1)) > 0) {
					sb.append(1).append("\n");
				}
				else sb.append(0).append("\n");
			}
			else if(s[0].equals("toggle")) {
				myBit = myBit ^ 1<<(temp-1);
			}
			else if(s[0].equals("all")) {
				myBit = ~0;
			}
			else if(s[0].equals("empty")) {
				myBit = myBit & 0;
			}
		}
		System.out.println(sb);
	}
}
