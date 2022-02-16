import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int res=0;
		Deque<Integer> player = new LinkedList<Integer>();
		player.offer(1);
		for(int i=0;i<N-1;i++) {
			player.offer(0);
		}
		while(player.peek()!=M) {
			int peek = player.peek();
			for(int i=0;i<L;i++) {
				int temp;
				if(peek==0) {
					temp = player.poll();
					player.offer(temp);
				}
				else {
					temp = player.pollLast();
					player.offerFirst(temp);
				}
			}
			player.offerFirst(player.poll()+1);
			res++;
			
		}
		System.out.println(res);
		
		
		
		
	}
	
	

}
