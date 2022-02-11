package BOJ;

/**
 * @author us13579
 * @since 2022-02-08, 1시간 10분
 * @title 후위표기식2, 실버 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		// 숫자 배열
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Double> q = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char x = str.charAt(i);
			// 알파벳 대문자이면 stack에 add
			if(str.charAt(i) - 65 >= 0 && str.charAt(i) - 90 <= 0) {
				q.add(arr[x-65]*1.0);
			}
			// 연산문자이면 앞에 2개 가져와서 계산
			else {			
				double a = q.pop();
				double b = q.pop();
				double c = 0.0;
			switch(x) {
			// 뒤에서 앞에 것을 계산해주어야한다
			case '*':
				c = b * a;
				break;
			case '/':
				c = b / a;
				break;
			case '+':
				c = b + a;
				break;
			case '-':
				c = b - a;
				break;
			}
			q.add(c);
			}

		}
		double x = q.pop();
		System.out.printf("%.2f", x);
		
	} 


}
