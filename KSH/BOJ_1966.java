package day5;

import java.util.LinkedList;
import java.util.Scanner;

// 프린터 큐
public class BOJ_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt(); 	// 문서 수
			int loc = sc.nextInt();	// 궁금한 문서의 위치

			// 프린터 큐
			LinkedList<int[]> queue = new LinkedList<>();

			// [초기 인덱스, 중요도] 입력
			for(int i=0; i<n; i++) {
				queue.offer(new int[] {i, sc.nextInt()});
			}

			// 몇 개 빠졌나?
			int cnt = 0;

			while(!queue.isEmpty()) {
				// 지금 뽑으려고 하는 문서
				int[] head = queue.poll();
				// 이 문서가 가장 큰가?
				boolean max = true;
				// 큐에 나머지 문서들과 중요도를 비교
				for(int i=0; i<queue.size(); i++) {
					// head보다 중요도가 높은 문서가 큐 안에 존재하는 경우 (이미 head를 poll 했으니 get(i))
					if(head[1] < queue.get(i)[1]) {
						// head를 큐에 다시 줄세우고
						queue.offer(head);
						// 나머지 원소를 뒤로 보낸다.
						for(int j=0; j<i; j++) {
							queue.offer(queue.poll());
						}
						// 지금 뽑으려는 문서인 head는 중요도가 가장 높지 않았다.
						max = false;
						break;
					}
				}
				// 만약 지금 뽑으려는 문서인 head의 중요도가 가장 높지 않았다면, 다음 문서 뽑자.
				if(max == false) continue;
				
				// 지금 뽑으려는 문서가 가장 크다. 뽑아라!
				else if(max == true) {
					cnt++;
					
					// 근데 지금 뽑으려는 문서가 내가 원하는 문서였다!
					if(head[0] == loc) break;
				}
			}
			// 몇 번째로 뽑혔는지 출력
			System.out.println(cnt);
		}
	}
}
