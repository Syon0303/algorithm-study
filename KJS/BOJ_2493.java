import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author us13579
 * @since 2022-02-07
 * @title 탑
 * 
 */

public class BOJ_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Integer> rootStack = new Stack<>();
		Stack<Integer> indexStack = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int first = Integer.parseInt(st.nextToken());
		rootStack.push(first);
		indexStack.push(1);
		sb.append("0 ");

		for (int i = 2; i <= N; i++) {
			int value = Integer.parseInt(st.nextToken());

			while (!rootStack.isEmpty()) {
				// stack에 있는 값이 새로 push 되려는 값보다 클 경우
				if (value < rootStack.peek()) {
					sb.append(indexStack.peek() + " ");
					break;
				}
				// stack에 있는 값이 새로 push 되려는 값보다 작을 경우
				rootStack.pop();
				indexStack.pop();
			}

			// stack이 비어있을 경우
			if (rootStack.isEmpty()) {
				sb.append("0 ");
			}
			rootStack.push(value);
			indexStack.push(i);
		}

		System.out.println(sb.toString());
	}

}
