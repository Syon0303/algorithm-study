import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		StringTokenizer stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < P.length; i++) {
			P[i] = Integer.parseInt(stn.nextToken());
		}
		Arrays.sort(P);
		int sum = 0;
		int by = N;
		for (int i = 0; i < P.length; i++) {
			sum += P[i] * by;
			by--;
		}
		System.out.println(sum);
	}
}