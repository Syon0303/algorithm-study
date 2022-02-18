import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//
	static int N, S, arr[], sum = 0, res = 0, check = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stn.nextToken());
		S = Integer.parseInt(stn.nextToken());
		arr = new int[N];
		stn = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(stn.nextToken());
		}
		Subset(0);
		System.out.println(res);
	}
	
	public static void Subset(int cnt) {
		// 마지막
		if(cnt >= N) {
			// 합이 S 인 경우 (공집합은 제외)
			if(sum == S && check != 0) {
				res++;
			}
			return;
		}
		
		// 부분 집합 코드 (모든 원소를 다 더한 경우 부터 시작해서 한 개씩 제외시키고 더하면서 구함)
		sum += arr[cnt];
		check++; // 공집합 체크
		Subset(cnt+1);
		
		sum -= arr[cnt];
		check--;
		Subset(cnt+1);
	}
}
