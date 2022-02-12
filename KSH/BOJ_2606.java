package day6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 바이러스
public class BOJ_2606 {
	
	static int[][] map;
	static int[] v;
	
	
	static void func() {
		Queue<Integer> queue = new LinkedList<>();
		
		v[1] = 1; // 1번 줄을 방문했으므로 v[1] = true(1)
		queue.offer(1);	// 큐에 1을 일단 넣음
		
		while(!queue.isEmpty()) { // 처음에 큐에 1이 들어가있음
			int temp = queue.poll(); // 처음엔 temp = 1이고, line(27)에서 1행이 true(1)인 수가 queue에 들어감
			
			for(int i=1; i<map.length; i++) { // 컴퓨터의 수 만큼 돌아라
				
				// 만약, 큐에서 뽑은 값이 i랑 연결되어있고, i에 방문하지 않았다면
				if(map[temp][i] == 1 && v[i] != 1) {
					queue.offer(i); // 감염된 컴퓨터 번호(i)를 queue에 넣어라
					v[i] = 1; // 감염을 확인했으니 방문했다고 체크
				}
			}
		}
		int sum = 0;
		for(int i:v) if(i==1) sum++; 
		
		// v[1]은 포함되지 않으므로 1을 뺀다.
		System.out.println(sum-1);
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodeNum = sc.nextInt(); // 컴퓨터의 수
		int edgeNum = sc.nextInt(); // 쌍의 수

		map = new int[nodeNum+1][nodeNum+1]; // 노드가 어떻게 연결되어 있는지를 저장하는 배열
		v = new int[nodeNum+1]; // 방문했는지 검사하는 배열 (1~7)

		// 그래프 채우기
		for(int i=1; i<=edgeNum; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			map[num1][num2] = 1;
			map[num2][num1] = 1;
		}
		func();
	}
}
