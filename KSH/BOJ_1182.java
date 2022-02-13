import java.util.Scanner;

// 부분 수열의 합
public class BOJ_1182 {

	static int N;
	static int S;
	static int[] arr;
	static int sum;
	static int res;
	
	static void dfs(int n, int sum) {
//		System.out.println("dfs(" + n + ", " + sum + ")");
		if(n==N) {
			if (sum == S) {
				res += 1;
			}
			return;
		}
		
		// 나를 고르는 경우의 수
		dfs(n+1, sum+arr[n]);
		
		// 나를 고르지 않는 경우의 수
		dfs(n+1, sum);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<arr.length; i++) arr[i] = sc.nextInt();
		
		dfs(0, 0);
		// S에 0이 들어왔을 때 아무것도 고르지 않으면 합이 0 이 되는 경우의 수를 빼준다.
		if(S==0) System.out.println(res-1);
		
		else System.out.println(res);
	}

}
