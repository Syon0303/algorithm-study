import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<int[]> stack = new Stack<int[]>();
		String [] temp = br.readLine().split(" ");
		
		int res[] = new int[N];
		int top;
		int [] push;

		for(int i=0; i<N;i++) {
			top = Integer.parseInt(temp[i]);
			push = new int[2];
			push[0] = top;
			push[1] = i+1;
			while(!stack.isEmpty()&&stack.peek()[0]<top) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				stack.add(new int[]{top,i+1});
				System.out.print("0 ");
				continue;
			}
			
			System.out.print(stack.peek()[1]+" ");
			stack.add(push);	
		}
		
	}

	
		
		

}
