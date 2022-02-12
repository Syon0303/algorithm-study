import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int [] T;
	static int[] P;
	static boolean [] check;
	static int max;
	static int N;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N];
		P = new int[N];
		max = Integer.MIN_VALUE;
		check = new boolean[N];
		for(int i=0;i<N;i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		fun(0);
		System.out.println(max);
		
	}
	public static void fun(int cnt) {
		int sum=0;
		
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				if(check[i]) {
					sum+=P[i];
				}
			}
			max = Math.max(max, sum);

			return;
		}
		//True
		if(cnt+T[cnt]<=N) {
			check[cnt] = true;
			for(int i=cnt+1;i<cnt+T[cnt];i++) {
				if(i>=N)break;
				check[i] = false;
			}
			fun(cnt+T[cnt]);
		}
		
		//False
		check[cnt] = false;
		fun(cnt+1);
	}

}
