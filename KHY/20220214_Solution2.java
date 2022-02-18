import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Ingredient {
	int s;
	int b;
	Ingredient(int s, int b){
		this.s = s;
		this.b = b;
	}
}
public class Main {
	static int N, total_s = 1, total_b = 0, min = Integer.MAX_VALUE, check = 0;
	static Ingredient[] I, arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 재료의 개수
		I = new Ingredient[N];
		arr = new Ingredient[N];
		visited = new boolean[N];
		// 쓴맛 신맛 정보가 있는 객체 생성
		for (int i = 0; i < N; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stn.nextToken()); // 신맛
			int b = Integer.parseInt(stn.nextToken()); // 쓴맛
			I[i] = new Ingredient(s, b);
		}
		subset(0); // 부분집합
		System.out.println(min);
	}
	static void subset(int cnt) {
		if(cnt == N) {
			if(check != 0) { // 공집합은 제외
				int total_s = 1; //초기화
				int total_b = 0; 
				for (int i = 0; i < N; i++) {
					if(visited[i]) {
						total_s *= I[i].s; // 신맛은 곱
						total_b += I[i].b; // 쓴맛은 합
					}
				}
				min = Math.min(min, Math.abs(total_s-total_b));
			}
			return;
		}
		visited[cnt] = true; // 부분집합 체크
		check++; // 공집합 체크
		subset(cnt+1);
		visited[cnt] = false;
		check--;
		subset(cnt+1);
	}
}