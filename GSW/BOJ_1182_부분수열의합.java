import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int [] arr;
	static int sum;
	static int res;
	static boolean check[];
	static int N;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sum = sc. nextInt(); 
		arr = new int[N];
		check = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i]  = sc.nextInt();
		}
		fun(0);
		System.out.println(res);
		
	}
	public static void fun(int cnt) {
		if(cnt==N) {
			int temp=0;
			boolean flag=false;
			for(int i=0;i<N;i++) {
				if(check[i]) {
					flag=true;
					temp+=arr[i];
				}
			}
			if(sum==temp&&flag) {
				res++;
			}
			return;
		}
		check[cnt] = true;
		fun(cnt+1);
		check[cnt] = false;
		fun(cnt+1);
	}

}
