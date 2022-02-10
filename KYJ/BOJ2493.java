import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        	// stack으로 입력 받으면서 풀어야 시간초과 나지 않음
		Stack<int[]> tops = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			int v = Integer.parseInt(st.nextToken());

			while (!tops.isEmpty()) {
				if (tops.peek()[1] >= v) {
					sb.append(tops.peek()[0] + " ");
					break;
				}
                		// 현재 탑보다 왼쪽에 있는 탑이 더 작다면, 왼쪽 탐은 영원히 레이저를 수신할 수 없음. 따라서 pop
				tops.pop();
			}

            		// 탑이 비었다면 0
			if (tops.isEmpty()) {
				sb.append("0 ");
			}
			// int 배열을 stack에 push
			tops.push(new int[] { i, v });
		}
		
		System.out.println(sb.toString());
	}
}
