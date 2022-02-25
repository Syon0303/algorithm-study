import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ArrayList<Character>[] list = new ArrayList[5];
			for (int i = 0; i < 5; i++) {
				list[i] = new ArrayList<Character>();
			}
			int max = 0;
			// 배열 입력
			for (int i = 0; i < 5; i++) {
				char[] temp = br.readLine().toCharArray();
				max = Math.max(max, temp.length); // 최대 문자열 길이
				// Arraylist 배열에 각각 길이가 다른 Arraylist 추가
				for (int j = 0; j < temp.length; j++) {
					list[i].add(temp[j]);
				}
			}
			int cnt = 0; // 열
			System.out.print("#"+t+" ");
			while(true) {
				// 현재 탐색 열이 최대 문자열 길이 보다 크거나 같아졌으면 종료
				if(max <= cnt) break; 
				// 5개 행만큼 문자 출력
				for (int i = 0; i < 5; i++) {
					// 현재 탐색 열이 Arraylist의 문자열보다 작아야함
					if(cnt < list[i].size()) {
						System.out.print(list[i].get(cnt));
					}
				}
				cnt++;
			}
			System.out.println();
		}
	}
}