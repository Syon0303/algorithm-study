import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 개수
		int[][] canvas = new int[101][101]; // 도화지
		for(int i = 0; i < N; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 색종이 채우기
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					canvas[j][k] = 1;
				}
			}
		}
		int res = 0;
		for(int i = 0; i < canvas.length; i++) {
			for(int j = 0; j < canvas[i].length; j++) {
				if(canvas[i][j] == 1) res++;
			}
		}
		System.out.println(res);
	}
}