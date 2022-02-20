import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 1 동쪽으로 2 서족으로 3 남쪽으로 4 북쪽으로
		int[][] list = new int[6][2];
		int maxHeight = Integer.MIN_VALUE;
		int maxWidth = Integer.MIN_VALUE;
		for (int i = 0; i < 6; i++) {
			list[i][0] = sc.nextInt();
			list[i][1] = sc.nextInt();
			if (list[i][0] == 1 || list[i][0] == 2)
				maxWidth = Math.max(maxWidth, list[i][1]);
			else if (list[i][0] == 3 || list[i][0] == 4)
				maxHeight = Math.max(maxHeight, list[i][1]);
		}
		int total = maxHeight * maxWidth;
		int width = 0;
		int height = 0;
		for (int i = 6; i < 12; i++) {
			if (list[(i - 1) % 6][1] + list[(i + 1) % 6][1] == maxHeight) {
				if (list[i%6][0] == 1 || list[i%6][0] == 2)
					width = list[i % 6][1];
			}
			if (list[(i - 1) % 6][1] + list[(i + 1) % 6][1] == maxWidth) {
				if (list[i%6][0] == 3 || list[i%6][0] == 4)
					height = list[i % 6][1];
			}
		}
		System.out.println((total - width * height) * N);
	}

}