import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] map;
	static boolean [] check;
	static int limit;
	static int res;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int t=1;t<=testCase;t++) {
			N=sc.nextInt();
			limit = sc.nextInt();
			map = new int[N][2];
			res = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			check = new boolean[N];
			fun(0);
			System.out.printf("#%d %d\n",t,res);
		}
	}
	public static void fun(int cnt) {
		if(cnt == N) {
			int sum =0;
			int sum2 =0;
			for(int i=0;i<N;i++) {
				if(check[i]) {
					sum+=map[i][0];
					sum2+=map[i][1];
				}
				if(sum2>limit) {
					sum=0;
				}
			}
			if(sum>res) res=sum;
			return;
		}
		check[cnt] = true;
		fun(cnt+1);
		check[cnt] = false;
		fun(cnt+1);	
	}

}
