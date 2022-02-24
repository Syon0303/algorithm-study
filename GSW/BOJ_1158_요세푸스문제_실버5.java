import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class BOJ_1158_요세푸스문제_실버5 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue <Integer> queue = new LinkedList<Integer>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		System.out.print("<");
		while(queue.size()!=1) {
			
			for(int i=1;i<K;i++) {
				queue.offer(queue.poll());
			}
			System.out.print(queue.poll()+", ");
		}
		System.out.print(queue.poll()+">");
		
		
	
	}
}