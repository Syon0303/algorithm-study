import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[][] area = new int[6][2];
		int[] visited = new int[5];
		for (int i = 0; i < 6; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			area[i][0] = Integer.parseInt(stn.nextToken()); // 방향
 			area[i][1] = Integer.parseInt(stn.nextToken()); // 거리
			visited[area[i][0]]++;
		}
		// 한 번만 나온 숫자 list에 추가 (2개)
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 4; i++) {
			if(visited[i] == 1) {
				list.add(i);
			}
		}
		int all = 1; // 큰 사각형의 넓이
		int sub = 0;
		for (int i = 0; i < 6; i++) {
			// 하나인 것 찾았으면 
			if(area[i][0] == list.get(0) || area[i][0] == list.get(1)) {
				// 1개인 것이 처음과 끝일 경우
				if(i == 0 && (area[5][0] == list.get(0) || area[5][0] == list.get(1))) {
					all = area[0][1] * area[5][1];
					sub = area[2][1] * area[3][1];
				}else {
					all = area[i][1] * area[i+1][1];
					
					sub = area[(i+3) % 6][1] * area[(i+4) % 6][1];
				}
				break;
			}
		}
		System.out.println(K * (all-sub));
	}
}