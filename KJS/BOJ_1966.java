package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-09, 2시간
 * @title 프린터 큐, 실버3
 */

public class BOJ_1966 {
	static StringTokenizer st;
	static Queue<int[]> queue;
	static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 입력
		int tc = Integer.parseInt(br.readLine());
		int z = 0;
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			// 문서의 개수
			int N = Integer.parseInt(st.nextToken());

			// 궁금한 문서가 몇번째 놓여있는지
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			// 중요도 배열 입력 -> LinkedList는 각 원소별로 비교하기 유용
			LinkedList<int[]> q = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				int input = Integer.parseInt(st.nextToken());
				q.add(new int[] { i, input }); // (index, 중요도)
			}

			// 몇번째로 인쇄
			int res = 0;

			while (!q.isEmpty()) {
				// 우선순위 확인 변수
				boolean isMax = true;
				// 젤 앞 원소 추출
				int[] p = q.poll();

				// LinkedList 돌면서 중요도 비교 -> 중요도 큰게 있으면 false
				for (int i = 0; i < q.size(); i++) {
					if (p[1] < q.get(i)[1]) {
						q.add(p);
						for (int j = 0; j < i; j++) {
							q.add(q.poll());
						}
						isMax = false;
						break;
					}

				}

				if (isMax == false) {
					continue;
				}
				
				// 찾으려는 원소보다 큰 것들은 인쇄 횟수 처리
				res++;
				//isMax == true 인 것 중 찾으려는 값 M 자리에 있는 것
				if (p[0] == M) {
					break;
				}
			}

			sb.append(res).append("\n");
		}

		System.out.println(sb);

	}
}
