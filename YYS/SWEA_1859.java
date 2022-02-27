import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int [N];
			int[][] arr2 = new int[N][2]; //2차원배열로 인덱스와 다시 저장
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				arr2[i][0] = arr[i];
				arr2[i][1] = i;
			}
			Arrays.sort(arr2, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) { // arr2를 내림차순으로 정렬 : 최대값들이 왼쪽에 배치
					// TODO Auto-generated method stub
					return o1[0]==o2[0]?-(o1[1]-o2[1]):-(o1[0]-o2[0]);
				}});
			int idx = 0;
			boolean end = false;
			long res = 0;
			for(int i=0; i<N-1;i++) {
					if(idx>=N) {
						i=N;
						end = true;
						break;
					}
				}
				if(!end) {// 크기와 인덱스가 더 큰 값이라면 i뒤에 있는 값중 최대값이므로 계산
					idx++;
					res += arr2[idx][0]-arr[i];
				}
			}
			System.out.println("#"+t+" "+res);
			
		}
	}

} 