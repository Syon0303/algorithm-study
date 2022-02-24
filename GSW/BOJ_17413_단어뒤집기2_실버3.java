import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_17413_단어뒤집기2_실버3 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String [] str = sc.nextLine().split("");
		Stack<String> stack = new Stack<String>();
		int len = str.length;
		for(int i=0;i<len;) {
			if(str[i].equals("<")) {
				while(!str[i].equals(">")) {
					sb.append(str[i]);
					i++;
				}
				sb.append(str[i]);
				i++;
			}
			else if(str[i].equals(" ")) {
				sb.append(str[i]);
				i++;
				
			}
			else {
	
				while(i<len&&!(str[i].equals(" ")||str[i].equals("<"))) {
					stack.push(str[i]);
					i++;
				}
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				//sb.append(" ");
			}
		}
		System.out.println(sb.toString());
		
	}

}