import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BOJ1935 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] ex = br.readLine().toCharArray();
		Stack<Double> operandStack = new Stack<>();
		int[] operandArr = new int[N];
		for(int i = 0; i < N; i++) {
			operandArr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < ex.length; i++) {
			switch(ex[i]) {
			// operator이면 pop해서 계산 후 다시 push
			case '+': case '-': case '*': case '/':
				double o2 = operandStack.pop();
				double o1 = operandStack.pop();
				switch(ex[i]) {
				case '+':
					operandStack.push(o1+o2);
					break;
				case '-':
					operandStack.push(o1-o2);
					break;
				case '*':
					operandStack.push(o1*o2);
					break;
				case '/':
					operandStack.push(o1/o2);
					break;	
				}
				break;
			// operand이면 push
			default:
				operandStack.push((double)operandArr[ex[i]-'A']);
			}
		}
		System.out.printf("%.2f\n", operandStack.pop());
	}
}
