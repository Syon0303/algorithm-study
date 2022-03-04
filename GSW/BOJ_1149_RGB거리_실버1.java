import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리_실버1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		int min = Integer.MAX_VALUE;
		int temp;
		for(int i=0;i<3;i++) {
			arr[0][i] = sc.nextInt();
		}
		
		for(int i=1;i<N;i++) {
			arr[i][0] = Math.min(arr[i-1][1], arr[i-1][2]) + sc.nextInt();
			arr[i][1] = Math.min(arr[i-1][0], arr[i-1][2]) + sc.nextInt();
			arr[i][2] = Math.min(arr[i-1][0], arr[i-1][1]) + sc.nextInt();
		}
		int res = Math.min(arr[N-1][0],arr[N-1][1]);
		res = Math.min(res,arr[N-1][2]);
		System.out.println(res);
	}

}