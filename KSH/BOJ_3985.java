import java.util.Scanner;

// 롤 케이크, 브론즈 1, 20분
public class BOJ_3985 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] v = new int[L];
		
		int wantMax = 0;
		int wantMaxIdx = 0;
		
		for(int i=0; i<N; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			if(wantMax < second-first) {
				wantMax = Math.max(wantMax, second-first);
				wantMaxIdx = i+1;
			}
			
			for(int j=first-1; j<second; j++) {
				if(v[j] == 0) v[j] = i+1;
			}
		}
		
		int[] res = new int[N+1]; // 각 사람이 몇 개 받았는지?
		for(int i=0; i<v.length; i++) {
			res[v[i]]++;
		}
		
		int max = 0;
		int maxIdx = 0;
		for(int i=1; i<res.length; i++) {
			if(res[i] > max) {
				max = Math.max(res[i], max);
				maxIdx = i;
			}
		}
		
		System.out.println(wantMaxIdx);
		System.out.println(maxIdx);
	}

}
