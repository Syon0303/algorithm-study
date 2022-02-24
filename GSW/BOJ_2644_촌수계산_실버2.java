import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class BOJ_2644_촌수계산_실버2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue <Integer> queue  = new LinkedList<Integer>(); 
		int N = sc.nextInt();
		int [][] map = new int[N][N];
		int [] target = new int[2];
		int check[] = new int[N];
		target[0] = sc.nextInt()-1;
		target[1] = sc.nextInt()-1;
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		queue.offer(target[0]);
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			if(index==target[1]) break;
			for(int i=0;i<N;i++) {
				if(map[index][i]==1&&check[i]==0) {
					check[i] = check[index]+1;
					queue.offer(i);
				}
			}
		}
		if(check[target[1]]==0) check[target[1]] = -1;
		System.out.println(check[target[1]]);
		
	}

}