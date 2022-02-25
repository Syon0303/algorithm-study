package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Magnetic, D3, 1시간
public class SEA_1220 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case=1; test_case<=10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];		
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int flag = 0;
			int res = 0;

			// 열부터 보는게 포인트
			for(int j=0; j<N; j++) {
				for(int i=0; i<N; i++) {
					// 만약 0 만나면 패스
					if(map[i][j]==0) continue;
					// 만약 열 보다가 빨간 자성체를 만나면 flag = 1
					else if(map[i][j]==1) flag = 1;
					// 이번 열에 빨간 자성체를 만났고 파란 자성체를 만난다면 교착++ 및 flag = 0 
					else if(flag==1 && map[i][j]==2) {
						res++;
						flag = 0;
					}
				}
				// 한 열을 다 보면 flag 초기화
				flag = 0;
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}
