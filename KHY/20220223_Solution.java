import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int[][] cards = new int[4][14];
			String[] data = br.readLine().split("");
			boolean flag = false;
			for (int j = 0; j < data.length; j+=3) {
				switch (data[j]) {
				case "S":
					if(cards[0][Integer.parseInt(data[j+1] + data[j+2])] == 1) {
						flag = true;
						break;
					}
					cards[0][Integer.parseInt(data[j+1] + data[j+2])]++;
					break;
				case "D":
					if(cards[1][Integer.parseInt(data[j+1] + data[j+2])] == 1) {
						flag = true;
						break;
					}
					cards[1][Integer.parseInt(data[j+1] + data[j+2])]++;
					break;
				case "H":
					if(cards[2][Integer.parseInt(data[j+1] + data[j+2])] == 1) {
						flag = true;
						break;
					}
					cards[2][Integer.parseInt(data[j+1] + data[j+2])]++;
					break;
				case "C":
					if(cards[3][Integer.parseInt(data[j+1] + data[j+2])] == 1) {
						flag = true;
						break;
					}
					cards[3][Integer.parseInt(data[j+1] + data[j+2])]++;
					break;
				}
			}
			System.out.print("#"+i);
			if(flag) {
				System.out.print(" ERROR");
			}else {
				for (int j = 0; j < 4; j++) {
					int res = 0;
					for (int k = 1; k <= 13; k++) {
						if(cards[j][k] == 0) {
							res++;
						}
					}
					System.out.print(" "+res);
				}
			}
			System.out.println();
		}
	}
}