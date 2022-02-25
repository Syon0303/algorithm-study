package day16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 요세푸스 문제, 실버 5, 10분
public class BOJ_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) queue.offer(i);
		System.out.print("<");
		while(!queue.isEmpty()) {
			if(queue.size()==1) {
				System.out.print(queue.poll() + ">");
				break;
			}
			for(int i=0; i<K-1; i++) queue.offer(queue.poll());
			System.out.print(queue.poll() + ", ");
		}
	}
}
