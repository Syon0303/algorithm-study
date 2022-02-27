import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= testCase; t++) {
			////////////////////////////
			int N = sc.nextInt();
			int max = Integer.MIN_VALUE;
			int[] arr = new int[N]; // 매매가 배열
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				max = Math.max(max, arr[i]);
			}
			int sum = 0; // 구매에 쓴돈
			int count = 0;
			long res = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] != max) {
					sum += arr[i];
					count++;
				}

				else {
					res += arr[i] * count - sum;
					count = 0;
					sum = 0;
					max = Integer.MIN_VALUE;
					for (int j = i + 1; j < N; j++) {
						max = Math.max(max, arr[j]);
					}

				}
			}
			System.out.printf("#%d %d%n",t,res);

			///////////////////////
		}

	}
}
