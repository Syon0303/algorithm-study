import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int row, col, R, t1, t2, arr[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {			
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(stn.nextToken());
			int N = Integer.parseInt(stn.nextToken());
			double num = 1;
			double den = 1;
			//nCr = (n-r)!/r!
			// 분자 계산 (n-r)!
			for (int j = N; j > N-R; j--) {
				num = num * j;
			}
			// 분모 계산 r!
			for (int j = R; j > 0; j--) {
				den = den * j;
			}
			double res = Math.round(num/den);
			System.out.println((int)res);
		}
		
	}
}