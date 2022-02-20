import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int arr [] = new int[L+1];
		int check[] = new int[N+1];
		int res1=0;
		int res2=0;
		int max= Integer.MIN_VALUE;
		for(int i=1;i<=N;i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			if(max<end-start) {
				res1=i;
				max=end-start;
			}
			for(int j=start;j<end+1;j++) {
				if(arr[j]==0) arr[j] = i;
			}
			
		}
		for(int i=1;i<=L;i++) {
			check[arr[i]]++;
		}
		max=Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			if(max<check[i]) {
				res2 = i;
				max=check[i];
			}
		}
		System.out.println(res1);
		System.out.println(res2);
	}

}