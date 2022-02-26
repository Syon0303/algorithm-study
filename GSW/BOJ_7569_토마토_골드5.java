import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Queue;

public class BOJ_7569_토마토_골드5 {
	public static class Tomato{
		int x,y,day;
		public Tomato(int y,int x,int day) {
			this.day = day;
			this.x=x;
			this.y=y;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//int map[][] = new int[M][N];
		boolean check[][] = new boolean[M][N];
		Queue<Tomato> queue = new LinkedList<Tomato>();
		int total=0;
		int res = Integer.MIN_VALUE;
		int [] dx = {-1,1,0,0};
		int [] dy = {0,0,1,-1};
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				//map[i][j] = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				if(t==1||t==-1) {
					check[i][j] = true;
					if(t==1) queue.offer(new Tomato(i,j,0));
				}
				else {
					total++;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Tomato cur = queue.poll();
			res = Math.max(res, cur.day);
			for(int i=0;i<4;i++) {
				int nextX = cur.x+dx[i];
				int nextY = cur.y+dy[i];
				if(nextX>=0&&nextX<N&&nextY>=0&&nextY<M&&!check[nextY][nextX]) {
					check[nextY][nextX] = true;
					queue.offer(new Tomato(nextY, nextX, cur.day+1));
					total--;
				}
			}
		}
		if(total!=0) res = -1;
		System.out.println(res);
		
		
		
		
		
	
	}
}