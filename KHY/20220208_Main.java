import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] com = br.readLine().split("");
		double[] nums = new double[N];
		Stack<Double> stack = new Stack<Double>();
		//숫자 배열 저장
		for(int i=0; i<N; i++) {
			nums[i] = Double.parseDouble(br.readLine());
		}
		for(int i=0; i<com.length; i++) {
			// 후위 표기식 계산기 구현
			if(com[i].equals("+")) {
				double b = stack.pop();
				double a = stack.pop();
				double res = a+b;
				stack.push(res);
			}else if(com[i].equals("-")) {
				double b = stack.pop();
				double a = stack.pop();
				double res = a-b;
				stack.push(res);				
			}else if(com[i].equals("*")) {
				double b = stack.pop();
				double a = stack.pop();
				double res = a*b;
				stack.push(res);				
			}else if(com[i].equals("/")) {
				double b = stack.pop();
				double a = stack.pop();
				double res = a/b;
				stack.push(res);
			// 알파벳일 때
			}else {
				stack.push(nums[com[i].charAt(0)-'A']); // 숫자 배열과 알파벳 매칭
			}
		}
		System.out.printf("%.2f",stack.pop());
	}
}
