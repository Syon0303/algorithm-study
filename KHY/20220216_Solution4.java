import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 화학 물질 개수
		Chemistry[] chemistries = new Chemistry[N];
		// 냉장고 온도 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stn.nextToken()); // 최저 온도
			int y = Integer.parseInt(stn.nextToken()); // 최고 온도
			chemistries[i] = new Chemistry(x, y);
		}
		Arrays.sort(chemistries); // 최고 온도 오름차순정렬 후 같으면 최저 온도 오름차순 정렬
		int res = 1; 
		int last = chemistries[0].y; // 끝점
		for (int i = 1; i < chemistries.length; i++) {
			// 끝점이 다음꺼의 시작지점보다 작으면 안 겹치는 것이므로
			if(chemistries[i].x > last) {
				last = chemistries[i].y; // 끝점 업데이트 해주고
				res++; // 냉장고 한개 추가
			}
		}
		System.out.println(res); // 냉장고 출력
	}
	static class Chemistry implements Comparable<Chemistry>{
		int x;
		int y;
		public Chemistry(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Chemistry o) {
			return (this.y - o.y) != 0 ? this.y - o.y : this.x - o.x;
		}
	}
}