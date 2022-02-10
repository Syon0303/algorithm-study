import java.util.Scanner;
 
class SWEA9229
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N, M;
			N = sc.nextInt();
			M = sc.nextInt();
			int[] snacks = new int[N];
			for(int i = 0; i < N; i++) {
				snacks[i] = sc.nextInt();
			}
			int max = -1;
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					int sum = snacks[i] + snacks[j];
					if(sum <= M) {
						max = Math.max(sum, max);
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
}
