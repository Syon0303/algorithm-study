package day15;

import java.util.Scanner;
import java.util.Stack;

// 단어 뒤집기 2, 실버 3, 20분
public class BOJ_17413 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		String s = sc.nextLine();
		boolean tagFlag = false;

		for(int i=0; i<s.length(); i++) {
			// 열린 태그를 만나면
			if(s.charAt(i) == '<') {
				// 여태까지 스택에 있던거 다 뱉어라
				while(!stack.isEmpty()) System.out.print(stack.pop());
				// 열려있으니 true
				tagFlag = true;
				// 열린 태그 출력
				System.out.print(s.charAt(i));
			}
			// 닫힌 태그를 만나면
			else if(s.charAt(i) == '>') {
				// 태그 닫았으니 false
				tagFlag = false;
				// 닫힌 태그 출력
				System.out.print(s.charAt(i));
			}
			// 만약 태그가 닫히지 않았다면 태그 안의 내용물 그냥 출력
			else if(tagFlag) System.out.print(s.charAt(i));

			// 태그와 관련이 없다면
			else {
				// 만약 공백을 만나면
				if(s.charAt(i) == ' ') {
					// 여태까지 스택에 담은거 다 뱉어라
					while(!stack.isEmpty()) System.out.print(stack.pop());
					// 공백도 찍어라
					System.out.print(s.charAt(i));
				}
				// 그냥 char라면 스택에 넣어라
				else stack.push(s.charAt(i));
			}
		}
		// 마지막이 숫자 또는 문자인 경우 스택 뱉어라
		while(!stack.isEmpty()) System.out.print(stack.pop());
	}
}
