import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1904_01타일_실버3 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		arr[0] = 0;
		arr[1] = 1;
		if (N > 1) {
			arr[2] = 2;
		}

		for (int i = 3; i <= N; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
		}

		System.out.println(arr[N]);
	}

}