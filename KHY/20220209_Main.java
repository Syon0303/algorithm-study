import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서 개수
			int M = Integer.parseInt(st.nextToken()); // 알고 싶은 문서의 현재 위치
			LinkedList<Integer> pri = new LinkedList<Integer>(); // 중요도
			st = new StringTokenizer(br.readLine());
			// 중요도 입력
			for (int j = 0; j < N; j++) {
				pri.offer(Integer.parseInt(st.nextToken()));
			}
			int cnt = 0; // 인쇄 count
			while (true) {
				int max = 0;
				// 현재 list의 max 값 찾기
				for (int j = 0; j < pri.size(); j++) {
					max = Math.max(pri.get(j), max);
				}
				// 원하는 것이 앞에 있을 경우
				if (M == 0) {
					if (pri.getFirst() == max) {
						cnt++; // count 증가
						break;
					// 리스트의 첫번째가 max값이 아니면 뒤로 이동
					} else {
						int tmp = pri.getFirst();
						pri.removeFirst();
						pri.addLast(tmp);
						M = pri.size() - 1;
					}
				// 중간에 있을 경우
				} else {
					// 리스트의 첫번째가 max값이랑 같으면 인쇄 (list에서 삭제)
					if (pri.getFirst() == max) {
						pri.removeFirst();
						cnt++; // count 증가
						M--; // M 위치 낮추기
					// 리스트의 첫번째가 max값이 아니면 뒤로 이동
					} else {
						int tmp = pri.getFirst();
						pri.removeFirst();
						pri.addLast(tmp);
						M--;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}