import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int nj[], arr[];
	static boolean pass, visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nj = new int[9]; // 아홉 난쟁이들
		arr = new int[7]; // 원래의 일곱 난쟁이들
		visited = new boolean[9];
		// 난쟁이 숫자 입력
		for (int i = 0; i < 9; i++) {
			nj[i] = Integer.parseInt(br.readLine());
		}
		combination(0,0); // 조합 재귀
		// 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void combination(int cnt, int start) {
		// 일곱 난쟁이 조합이면
		if(cnt == 7) {
			int sum = 0;
			// 각 난쟁이들의 숫자 전체 합을 구함
			for (int i = 0; i < 7; i++) {
				sum += arr[i];
			}
			// 숫자 합이 100이면
			if(sum == 100) {
				pass = true; // pass flag
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			// 일곱 난쟁이 조합 구했으면 종료
			if(pass) return;
			if(visited[i]) continue; // 중복 체크
			arr[cnt] = nj[i];
			visited[i] = true;
			combination(cnt+1, start+1);
			visited[i] = false;
		}
	}
}