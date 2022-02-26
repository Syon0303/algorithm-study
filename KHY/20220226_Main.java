import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 1; // 처음 왼쪽 한개 있는 상태로 오른쪽만 되는지 탐색
		char[] cups = br.readLine().toCharArray(); // 좌석
		for (int i = 0; i < N; i++) {
			switch (cups[i]) {
			// S면 오른쪽 가능
			case 'S':
				res++;
				break;
			// L이면 한개 건너 뛰고 오른쪽 가능
			case 'L':
				i++;
				res++;
				break;
			}
		}
		// 컵 홀더 개수가 사람 수 보다 많으면 사람 수 만큼 가능
		if(res > N) {
			System.out.println(N);		
		// 적으면 컵 홀더 개수만큼 가능
		}else {
			System.out.println(res);
		}
	}
}