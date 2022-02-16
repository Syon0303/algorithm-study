import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main_신맛쓴맛 {
	static int N;
	static int arr[];
	static int arr2[];
	static boolean check[];
	static int res;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		arr2 = new int[N];
		check = new boolean[N];
		res=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			arr2[i] = sc.nextInt();
		}
		set(0);
		System.out.println(res);
	}
	
	public static void set(int cnt) {
		if(cnt==N) {
			boolean flag =false;
			int sum=0;
			int mult=1;
			int temp;
			for(int i=0;i<N;i++) {
				if(check[i]) {
					mult*=arr[i];
					sum+=arr2[i];
					flag =true;
				}
			}
			if(!flag) return;
			res = Math.min(res,Math.abs(sum-mult) );
			return;
		}
		check[cnt] = true;
		set(cnt+1);
		check[cnt] = false;
		set(cnt+1);
	}

}
