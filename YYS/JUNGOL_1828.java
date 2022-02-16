import java.util.*;

public class Main {
	static int N,cnt = 0, arr[][];
	
	static void dfs(int depth, int maxC) {
		if(depth==N) { // N에 도달하면 종료
			return;
		}
		if(arr[depth][0]>maxC) { // 온도 범위 끝값보다 커질 때 새로 냉장고 생성
			cnt++;
			dfs(depth+1, arr[depth][1]); // 현재 화학물질 기준 온도 끝값 설정
		}else {
			dfs(depth+1, Math.min(maxC,arr[depth][1])); // 범위 안이라면 다음으로
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1];
			} //최대 온도로 오름차순 정렬, 같은 경우 최소 온도 오름차순
			
		});

		dfs(0,-271);
		System.out.println(cnt);
}
}