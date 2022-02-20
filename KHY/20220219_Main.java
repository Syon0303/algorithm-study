import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 1) System.out.println(1);
		else {
			int level = 1;
			int cnt = 2;
			while(true) {
				// cnt를 누적해서 더하다가 그 수보다 커지면 종료
				if(n < cnt) break;
				cnt += 6 * level;
				level++;
			}
			System.out.println(level);
		}
	}
}