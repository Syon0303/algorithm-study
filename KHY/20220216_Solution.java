import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stn.nextToken()); // 사람 수
		int M = Integer.parseInt(stn.nextToken()); // 공 받기 제한
		int L = Integer.parseInt(stn.nextToken()); // L번째 방향
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(0);
		}
		int res = 0;
		while(true) {
			int ball = list.getFirst(); // 현재 공 받은 사람
			// 홀수면
			if(ball % 2 != 0) {
				ball++; // 받은 횟수 증가시켜주고
				if(ball == M) break;
				list.removeFirst(); // 삭제
				// 받은 횟수가 M이 아니면
				if(ball != M) {
					list.addLast(ball); // 맨뒤에 넣기
				}
				// 시계방향으로 L번째에 공 던지기
				for (int i = 0; i < L-1; i++) {
					list.addLast(list.getFirst()); // 첫번째 뒤로 이동시키고
					list.removeFirst(); // 삭제
				}
			}
			// 짝수면
			else {
				ball++; // 받은 횟수 증가시켜주고
				if(ball == M) break;
				list.removeFirst(); // 삭제시켜주고
				// 받은 횟수가 M이 아니면
				if(ball != M) {
					list.addFirst(ball); // 처음에 다시 넣기
				}
				// 반시계방향으로 L번쨰에 공 던지기
				for (int i = 0; i < L; i++) {
					list.addFirst(list.getLast()); // 맨 뒤를 앞으로 이동시키고
					list.removeLast(); // 삭제
				}
			}
			res++;
		}
		System.out.println(res);
	}
}