package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author us13579
 * @since 2022-02-27, 10분
 * @title OX퀴즈
 * 
 */

public class BOJ_B2_8958 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String str = br.readLine();
			// 카운팅 변수
			int cnt = 0;
			// 결과 변수
			int res = 0;
			for(int i=0; i<str.length(); i++) {
				char temp = str.charAt(i);
				// 'O'를 만났을 때 카운팅해주고 바로 결과값에 저장한다.
				if(temp == 'O') {
					cnt ++;
					res += cnt;
				}
				// 'X'를 만났을 때 카운팅 변수를 0으로 초기화 한다.
				else if(temp == 'X') {
					cnt = 0;
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

}
