import java.io.IOException;
import java.util.Scanner;

public class Main_블랙잭 {
	static int num[];
	static int arr[];
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	static int res;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int [3];
		num = new int [N];
		for(int i=0;i<N;i++) {
			num[i] = sc.nextInt();
		}
		comb(0,0,0);
		System.out.println(res);
		
	}
	public static void comb(int cnt,int start,int sum) {
		if(sum>M) return;
		if(cnt==3) {
			int temp = min;
			min = Math.min(min, M-sum);
			if(temp!=min) {
				res = sum;
			}
			return;
		}
		for(int i=start;i<N;i++) {
			arr[cnt] = num[i];
			comb(cnt+1,i+1,sum+arr[cnt]);
		}
	}
		
	

}
