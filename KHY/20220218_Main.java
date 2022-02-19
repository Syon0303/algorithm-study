import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int res = 0;
		// 1부터 n까지
		for (int i = 1; i <= n; i++) {
			// 2*1과 1*2는 같은 것이므로 j=i부터 시작
			for (int j = i; j <= n; j++) {
				// 정사각형 개수 부족하면 종료
				if(i * j > n) break;
				res++;
			}
		}
		System.out.println(res);
	}
}