import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력
		for(int i=0; i<N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		//구현
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stackidx = new Stack<Integer>();
		for(int i=0; i<N; i++) {
			// 스택이 비어있다면 0 출력하고 stack에 추가
			if(stack.isEmpty()) {
				sb.append(0+" ");
				stack.push(top[i]);
				stackidx.push(i+1);
			// 스택이 비어있지 않다면 
			}else {
				//스택의 peek이 현재 탑보다 높다면 출력하고 stack에 추가
				if(stack.peek() > top[i]) {
					sb.append(stackidx.peek()+" ");
					stack.push(top[i]);
					stackidx.push(i+1);
				//스택의 peek이 현재 탑보다 낮다면 pop하고 다시 체크
				}else {
					stack.pop();
					stackidx.pop();
					i--;
				}
			}
		}
		System.out.println(sb);
	}
}
