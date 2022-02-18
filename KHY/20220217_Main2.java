import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			// A 입력
			int[] A = new int[5];
			int a = Integer.parseInt(stn.nextToken());
			for (int j = 0; j < a; j++) {
				A[Integer.parseInt(stn.nextToken())]++;				
			}
			// B 입력
			stn = new StringTokenizer(br.readLine());
			int[] B = new int[5];
			int b = Integer.parseInt(stn.nextToken());
			for (int j = 0; j < b; j++) {
				B[Integer.parseInt(stn.nextToken())]++;				
			}
			for(int j = 4; j >= 0; j--) {
				// 문양 개수가 같으면
				if(A[j] == B[j]) {
					// 마지막이면
					if(j == 0) {
						System.out.println("D");
					}
					continue;
				}
				// 문양 개수가 A가 더 크면
				if(A[j] > B[j]) {
					System.out.println("A");
					break;
				// 문양 개수가 B가 더 크면
				}else {
					System.out.println("B");
					break;
				}
			}
		}
	}
}